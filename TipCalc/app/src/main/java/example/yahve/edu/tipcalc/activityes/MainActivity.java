package example.yahve.edu.tipcalc.activityes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.yahve.edu.tipcalc.R;
import example.yahve.edu.tipcalc.TipCalcApp;
import example.yahve.edu.tipcalc.fragments.TipHistoryListFragment;
import example.yahve.edu.tipcalc.fragments.TipHistoryListFragmentListener;
import example.yahve.edu.tipcalc.models.TipRecord;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.inputBill)
    EditText inputBill;
    @Bind(R.id.inputPercentage)
    EditText inputPercentage;
    @Bind(R.id.txtTip)
    TextView txtTip;

    private TipHistoryListFragmentListener fragmentListener;

    private final static int TIP_STEP_CHANGE = 1;
    private final static int DEFAULT_TIP_PERCENTAGE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        TipHistoryListFragment fragment = (TipHistoryListFragment) getSupportFragmentManager()
                                            .findFragmentById(R.id.fragmentList);
        fragment.setRetainInstance(true);
        fragmentListener = (TipHistoryListFragmentListener)fragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_about){
            about();
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btnSubmit)
    public void handleClickSubmit(){
        hideKeyborard();
        String strInputTotal = inputBill.getText().toString().trim();
        if(!strInputTotal.isEmpty()){
            double total = Double.parseDouble(strInputTotal);
            int tipPercentage = getTipPercentage();
            TipRecord tipRecord = new TipRecord();
            tipRecord.setBill(total);
            tipRecord.setTipPercentage(tipPercentage);
            tipRecord.setTimestamp(new Date());
            fragmentListener.addToList(tipRecord);
            String strTip = String.format(getString(R.string.global_message_tip),tipRecord.getTip());
            txtTip.setVisibility(View.VISIBLE);
            txtTip.setText(strTip);

        }
    }

    @OnClick(R.id.btnIncrease)
    public void handleClickIncrease(){
        hideKeyborard();
        handleTipChange(TIP_STEP_CHANGE);
    }

    @OnClick(R.id.btnDecrease)
    public void handleClickDecrease(){
        hideKeyborard();
        handleTipChange(-TIP_STEP_CHANGE);
    }

    @OnClick(R.id.btnClear)
    public void handleClickClear(){
        hideKeyborard();
        fragmentListener.clearList();
    }

    public void handleTipChange(int change){
        int tipPercentage = getTipPercentage();
        tipPercentage +=change;
        if(tipPercentage>0){
            inputPercentage.setText(String.valueOf(tipPercentage));
        }
    }

    public int getTipPercentage() {
        int tipPercentage = DEFAULT_TIP_PERCENTAGE;
        String strInputTipPercentage = inputPercentage.getText().toString().trim();
        if(!strInputTipPercentage.isEmpty()){
            tipPercentage = Integer.parseInt(strInputTipPercentage);
        }else{
            inputPercentage.setText(String.valueOf(tipPercentage));
        }
        return tipPercentage;
    }

    public void  hideKeyborard(){
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        try{
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
        }catch (NullPointerException npe){
            Log.e(getLocalClassName(),Log.getStackTraceString(npe));
        }
    }

    private void about(){
        TipCalcApp app = (TipCalcApp)getApplication();
        String url = app.getAboutUrl();

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
