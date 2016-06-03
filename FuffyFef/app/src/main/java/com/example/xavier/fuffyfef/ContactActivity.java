package com.example.xavier.fuffyfef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.xavier.fuffyfef.config.SendMail;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    EditText input_message;
    EditText input_name;
    EditText input_email;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        input_email = (EditText)findViewById(R.id.input_email);
        input_name = (EditText)findViewById(R.id.input_name);
        input_message = (EditText)findViewById(R.id.input_message);
        btn_send = (Button) findViewById(R.id.btn_send);
        if (btn_send != null) {
            btn_send.setOnClickListener(this);
        }

    }

    private void sendEmail() {

        SendMail sm = new SendMail(this, input_email.getText().toString(),getApplicationContext().getString(R.string.app_name),
                input_name.getText().toString()+ " Comenta: " + input_message.getText().toString());

        sm.execute();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send:
                sendEmail();
                break;
        }
    }
}
