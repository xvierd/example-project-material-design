package com.example.xavier.fuffyfef.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xavier.fuffyfef.adapter.MascotRecyclerAdapter;
import com.example.xavier.fuffyfef.model.Mascot;
import com.example.xavier.fuffyfef.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {


    ArrayList<Mascot> mascots = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rc_mascots);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        initializeData();
        MascotRecyclerAdapter adapter = new MascotRecyclerAdapter(RecyclerViewFragment.this, mascots);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initializeData() {
        mascots.add(new Mascot("Fofy", 0, R.drawable.mascot_1));
        mascots.add(new Mascot("Paquita", 0, R.drawable.mascot_2));
        mascots.add(new Mascot("Candy", 0, R.drawable.mascot_3));
        mascots.add(new Mascot("Suchi", 0, R.drawable.mascot_4));
        mascots.add(new Mascot("Feliz", 0, R.drawable.mascot_5));
        mascots.add(new Mascot("Estrella", 0, R.drawable.mascot_6));
        mascots.add(new Mascot("Brando", 0, R.drawable.mascot_7));
        mascots.add(new Mascot("bongo", 0, R.drawable.mascot_8));
    }

}
