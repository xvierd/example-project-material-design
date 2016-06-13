package com.example.xavier.fuffyfef.Activity;

import android.content.Context;

import com.example.xavier.fuffyfef.model.BuilderMascots;
import com.example.xavier.fuffyfef.model.Mascot;

import java.util.ArrayList;

/**
 * Created by xavier on 12/06/16.
 */
public class FavoriteMascotsPresenter implements IFavorteMascotsPresenter {

    private IFavoriteMascotsView iFavoriteMascotsView;
    private Context context;
    private BuilderMascots builderMascots;
    private ArrayList<Mascot> mascots;

    public FavoriteMascotsPresenter(IFavoriteMascotsView iFavoriteMascotsView, Context context) {
        this.iFavoriteMascotsView = iFavoriteMascotsView;
        this.context = context;
        getMascots();
    }

    @Override
    public void getMascots() {
        builderMascots = new BuilderMascots(context);
        mascots = builderMascots.getMascots();
        showMascotsRV();
    }

    @Override
    public void showMascotsRV() {
        iFavoriteMascotsView.initializeAdapterRV(iFavoriteMascotsView.createAdapter(mascots));
        iFavoriteMascotsView.generteLinearLayoutVertical();
    }
}
