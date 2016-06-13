package com.example.xavier.fuffyfef.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.xavier.fuffyfef.R;
import com.example.xavier.fuffyfef.adapter.MascotRecyclerAdapter;
import com.example.xavier.fuffyfef.model.Mascot;

import java.util.ArrayList;

public class FavoriteMascots extends AppCompatActivity implements IFavoriteMascotsView {

    ArrayList<Mascot> mascots = new ArrayList<>();
    RecyclerView recyclerView;
    private IFavorteMascotsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_mascots);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_action_bar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.icon_app);
        recyclerView = (RecyclerView) findViewById(R.id.rc_mascots);
        presenter = new FavoriteMascotsPresenter(this,getApplicationContext());

    }


    @Override
    public void generteLinearLayoutVertical() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
    }

    @Override
    public MascotRecyclerAdapter createAdapter(ArrayList<Mascot> mascots) {
        MascotRecyclerAdapter adapter = new MascotRecyclerAdapter(null,mascots);
        return adapter;
    }

    @Override
    public void initializeAdapterRV(MascotRecyclerAdapter adapter) {
        recyclerView.setAdapter(adapter);

    }
}
