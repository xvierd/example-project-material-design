package com.example.xavier.fuffyfef;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.xavier.fuffyfef.adapter.MascotRecyclerAdapter;
import com.example.xavier.fuffyfef.pojo.Mascot;

import java.util.ArrayList;

public class FavoriteMascots extends AppCompatActivity {

    ArrayList<Mascot> mascots = new ArrayList<>();
    RecyclerView recyclerView;

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
        initializeData();
        recyclerView = (RecyclerView) findViewById(R.id.rc_mascots);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        MascotRecyclerAdapter adapter = new MascotRecyclerAdapter(null,mascots);
        recyclerView.setAdapter(adapter);
    }

    private void initializeData() {
        mascots.add(new Mascot("Fofy", 0, R.drawable.mascot_1, 0));
        mascots.add(new Mascot("Paquita", 0, R.drawable.mascot_2, 0));
        mascots.add(new Mascot("Candy", 0, R.drawable.mascot_3, 0));
        mascots.add(new Mascot("Suchi", 0, R.drawable.mascot_4, 0));
        mascots.add(new Mascot("Feliz", 0, R.drawable.mascot_5, 0));
    }
}
