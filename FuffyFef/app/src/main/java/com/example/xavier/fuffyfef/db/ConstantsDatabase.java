package com.example.xavier.fuffyfef.db;

/**
 * Created by xavier on 11/06/16.
 */
public final class ConstantsDatabase {

    public static final String DATABASE_NAME = "mascots";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOT = "mascot";
    public static final String TABLE_MASCOTS_ID = "id";
    public static final String TABLE_MASCOTS_NAME = "name";
    public static final String TABLE_MASCOTS_IMAGE = "image";

    public static final String TABLE_LIKES_MASCOTS = "mascot_likes";
    public static final String TABLE_LIKES_MASCOTS_ID = "id";
    public static final String TABLE_LIKES_MASCOT_ID_MASCOT = "id_mascot";
    public static final String TABLE_LIKES_MASCOTS_NUMBER_LIKES = "number_likes";
}
