package com.example.xavier.fuffyfef;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.xavier.fuffyfef.adapter.PageAdapter;
import com.example.xavier.fuffyfef.fragment.ProfileMascotFragment;
import com.example.xavier.fuffyfef.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageButton img_button_start;
    private Toolbar toolbar;
    private TabLayout tab_layout;
    private ViewPager view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.main_action_bar);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        toolbar.setNavigationIcon(R.drawable.icon_app);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        setUpViewPager();
        img_button_start = (ImageButton) findViewById(R.id.img_button_start);
        if (img_button_start != null) {
            img_button_start.setVisibility(View.VISIBLE);
            img_button_start.setOnClickListener(this);
        }
    }

    private ArrayList<Fragment> addFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new ProfileMascotFragment());
        return fragments;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.m_about_me:
                Intent i = new Intent(this, AboutMeActivity.class);
                startActivity(i);
                break;
            case R.id.m_contact:
                Intent intent =new Intent(this,ContactActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpViewPager() {

        view_pager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tab_layout.setupWithViewPager(view_pager);
        tab_layout.getTabAt(0).setIcon(R.drawable.ic_home);
        tab_layout.getTabAt(1).setIcon(R.drawable.ic_dog);


    }


    @Override
    public void onClick(View v) {
        if (v == img_button_start) {
            Intent intent = new Intent(this, FavoriteMascots.class);
            startActivity(intent);
        }
    }


}
