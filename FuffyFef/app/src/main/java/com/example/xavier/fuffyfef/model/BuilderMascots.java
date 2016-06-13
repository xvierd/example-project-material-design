package com.example.xavier.fuffyfef.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.xavier.fuffyfef.R;
import com.example.xavier.fuffyfef.db.ConstantsDatabase;
import com.example.xavier.fuffyfef.db.DataBase;

import java.util.ArrayList;

/**
 * Created by xavier on 12/06/16.
 */
public class BuilderMascots {

    private static final int LIKE = 1;
    private Context context;
    public BuilderMascots(Context context) {
        this.context = context;
    }

    public void insertFiveMascots(DataBase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDatabase.TABLE_MASCOTS_NAME, "Fofy");
        contentValues.put(ConstantsDatabase.TABLE_MASCOTS_IMAGE, R.drawable.mascot_1);

        db.insertMascot(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantsDatabase.TABLE_MASCOTS_NAME, "Paquita");
        contentValues.put(ConstantsDatabase.TABLE_MASCOTS_IMAGE, R.drawable.mascot_1);

        db.insertMascot(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantsDatabase.TABLE_MASCOTS_NAME, "Candy");
        contentValues.put(ConstantsDatabase.TABLE_MASCOTS_IMAGE, R.drawable.mascot_1);

        db.insertMascot(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantsDatabase.TABLE_MASCOTS_NAME, "Suchi");
        contentValues.put(ConstantsDatabase.TABLE_MASCOTS_IMAGE, R.drawable.mascot_1);

        db.insertMascot(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantsDatabase.TABLE_MASCOTS_NAME, "Feliz");
        contentValues.put(ConstantsDatabase.TABLE_MASCOTS_IMAGE, R.drawable.mascot_1);

        db.insertMascot(contentValues);
    }

    public void doLikeMascot(Mascot contacto){
        DataBase db = new DataBase(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDatabase.TABLE_LIKES_MASCOT_ID_MASCOT, contacto.getId());
        contentValues.put(ConstantsDatabase.TABLE_LIKES_MASCOTS_NUMBER_LIKES, LIKE);
        db.insertLikeMascot(contentValues);
    }

    public int getLikesMascot(Mascot contacto){
        DataBase db = new DataBase(context);
        return db.getLikesascot(contacto);
    }

    public ArrayList<Mascot> getMascots() {
        DataBase db = new DataBase(context);
        insertFiveMascots(db);
        return  db.getAllMascots();
    }
}
