package com.example.xavier.fuffyfef;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Mascot> mascots = new ArrayList<>();
    RecyclerView recyclerView;
    ImageButton img_button_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_action_bar);
        toolbar.setNavigationIcon(R.drawable.icon_app);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.rc_mascots);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        initializeData();
        MascotRecyclerAdapter adapter = new MascotRecyclerAdapter(mascots);
        recyclerView.setAdapter(adapter);
        img_button_start = (ImageButton) findViewById(R.id.img_button_start);
        img_button_start.setVisibility(View.VISIBLE);
        img_button_start.setOnClickListener(this);
    }

    private void initializeData() {
        mascots.add(new Mascot("Fofy", 0, R.drawable.mascot_1, 0));
        mascots.add(new Mascot("Paquita", 0, R.drawable.mascot_2, 0));
        mascots.add(new Mascot("Candy", 0, R.drawable.mascot_3, 0));
        mascots.add(new Mascot("Suchi", 0, R.drawable.mascot_4, 0));
        mascots.add(new Mascot("Feliz", 0, R.drawable.mascot_5, 0));
        mascots.add(new Mascot("Estrella", 0, R.drawable.mascot_6, 0));
        mascots.add(new Mascot("Brando", 0, R.drawable.mascot_7, 0));
        mascots.add(new Mascot("bongo", 0, R.drawable.mascot_8, 0));
    }

    @Override
    public void onClick(View v) {
        if (v == img_button_start) {
            Intent intent = new Intent(this, FavoriteMascots.class);
            startActivity(intent);
        }
    }
}
