package com.example.xavier.fuffyfef.Activity;

import com.example.xavier.fuffyfef.adapter.MascotRecyclerAdapter;
import com.example.xavier.fuffyfef.model.Mascot;

import java.util.ArrayList;

/**
 * Created by xavier on 11/06/16.
 */
public interface IFavoriteMascotsView {

    void generteLinearLayoutVertical();

    MascotRecyclerAdapter createAdapter(ArrayList<Mascot> mascots);

    void initializeAdapterRV(MascotRecyclerAdapter adapter);

}
