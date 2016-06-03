package com.example.xavier.fuffyfef.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xavier.fuffyfef.R;
import com.example.xavier.fuffyfef.adapter.MascotRecyclerAdapter;
import com.example.xavier.fuffyfef.pojo.Mascot;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileMascotFragment extends Fragment {


    ArrayList<Mascot> mascots = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_mascot,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rc_mascots);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager llm = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(llm);
        initializeData();
        MascotRecyclerAdapter adapter = new MascotRecyclerAdapter(ProfileMascotFragment.this, mascots);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initializeData() {
        mascots.add(new Mascot("Suchi", 0, R.drawable.mascot_4, 124));
        mascots.add(new Mascot("Suchi", 0, R.drawable.mascot_4, 3));
        mascots.add(new Mascot("Suchi", 0, R.drawable.mascot_4, 4));
        mascots.add(new Mascot("Suchi", 0, R.drawable.mascot_4, 3));
        mascots.add(new Mascot("Suchi", 0, R.drawable.mascot_4, 2));
        mascots.add(new Mascot("Suchi", 0, R.drawable.mascot_4, 1));
        mascots.add(new Mascot("Suchi", 0, R.drawable.mascot_4, 23));
        mascots.add(new Mascot("Suchi", 0, R.drawable.mascot_4, 8));
        mascots.add(new Mascot("Suchi", 0, R.drawable.mascot_4, 10));
    }

}
