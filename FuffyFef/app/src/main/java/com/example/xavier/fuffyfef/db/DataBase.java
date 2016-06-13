package com.example.xavier.fuffyfef.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.xavier.fuffyfef.model.Mascot;

import java.util.ArrayList;

/**
 * Created by xavier on 11/06/16.
 */
public class DataBase extends SQLiteOpenHelper {

    private Context context;

    public DataBase(Context context) {
        super(context, ConstantsDatabase.DATABASE_NAME, null, ConstantsDatabase.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCreateTableMascor = "CREATE TABLE " + ConstantsDatabase.TABLE_MASCOT + "(" +
                ConstantsDatabase.TABLE_MASCOTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantsDatabase.TABLE_MASCOTS_NAME + " TEXT, " +
                ConstantsDatabase.TABLE_MASCOTS_IMAGE + " INTEGER" +
                ")";

        String queryCreateTableLikesMascot = "CREATE TABLE " + ConstantsDatabase.TABLE_LIKES_MASCOTS + "(" +
                ConstantsDatabase.TABLE_LIKES_MASCOTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantsDatabase.TABLE_LIKES_MASCOT_ID_MASCOT + " INTEGER, " +
                ConstantsDatabase.TABLE_LIKES_MASCOTS_NUMBER_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantsDatabase.TABLE_LIKES_MASCOT_ID_MASCOT + ") " +
                "REFERENCES " + ConstantsDatabase.TABLE_MASCOT + "(" + ConstantsDatabase.TABLE_MASCOTS_ID + ")" +
                ")";

        db.execSQL(queryCreateTableMascor);
        db.execSQL(queryCreateTableLikesMascot);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantsDatabase.TABLE_MASCOT);
        db.execSQL("DROP TABLE IF EXIST " + ConstantsDatabase.TABLE_LIKES_MASCOTS);
        onCreate(db);

    }

    public ArrayList<Mascot> getAllMascots() {
        ArrayList<Mascot> mascots = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantsDatabase.TABLE_MASCOT;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascot mascot = new Mascot();
            mascot.setId(registros.getInt(0));
            mascot.setName(registros.getString(1));
            mascot.setImage(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantsDatabase.TABLE_LIKES_MASCOTS_NUMBER_LIKES+") as likes " +
                    " FROM " + ConstantsDatabase.TABLE_LIKES_MASCOTS +
                    " WHERE " + ConstantsDatabase.TABLE_LIKES_MASCOT_ID_MASCOT + "=" + mascot.getId();

            Cursor recordsLikes = db.rawQuery(queryLikes, null);
            if (recordsLikes.moveToNext()){
                mascot.setLikes(recordsLikes.getInt(0));
            }else {
                mascot.setLikes(0);
            }

            mascots.add(mascot);

        }

        db.close();

        return mascots;
    }

    public void insertMascot(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantsDatabase.TABLE_MASCOT,null, contentValues);
        db.close();
    }

    public void insertLikeMascot(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantsDatabase.TABLE_LIKES_MASCOTS, null, contentValues);
        db.close();
    }


    public int getLikesascot(Mascot mascot){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantsDatabase.TABLE_LIKES_MASCOTS_NUMBER_LIKES+")" +
                " FROM " + ConstantsDatabase.TABLE_LIKES_MASCOTS +
                " WHERE " + ConstantsDatabase.TABLE_LIKES_MASCOT_ID_MASCOT + "="+mascot.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor recordsLikes = db.rawQuery(query, null);

        if (recordsLikes.moveToNext()){
            likes = recordsLikes.getInt(0);
        }

        db.close();

        return likes;
    }
}
