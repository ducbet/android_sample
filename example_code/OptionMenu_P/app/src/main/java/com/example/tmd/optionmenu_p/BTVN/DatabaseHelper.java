package com.example.tmd.optionmenu_p.BTVN;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmd on 17/04/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "contact.db";
    public static final int DB_VERSION = 1;

    private final static String COMMAND_CREATE_CONTACT_TABLE =
            "CREATE TABLE "
                    + ContactContract.ContactEntry.TABLE_NAME
                    + " ( "
                    + ContactContract.ContactEntry._ID
                    + " INTEGER PRIMARY KEY NOT NULL, "
                    + ContactContract.ContactEntry.COLUMN_NAME
                    + " TEXT, "
                    + ContactContract.ContactEntry.COLUMN_PHONE
                    + " TEXT, "
                    + ContactContract.ContactEntry.COLUMN_ADDRESS
                    + " TEXT);";

    private final static String COMMAND_DELETE_CONTACT_TABLE = "DROP TABLE" + ContactContract.ContactEntry.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COMMAND_CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // delete old db
        db.execSQL(COMMAND_DELETE_CONTACT_TABLE);
        // and create new db
        db.execSQL(COMMAND_CREATE_CONTACT_TABLE);
    }



}
