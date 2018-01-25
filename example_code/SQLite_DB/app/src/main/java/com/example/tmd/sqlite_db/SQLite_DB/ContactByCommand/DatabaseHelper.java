package com.example.tmd.sqlite_db.SQLite_DB.ContactByCommand;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.tmd.sqlite_db.SQLite_DB.InfoContactDatabase;

/**
 * Created by tmd on 23/04/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DB_NAME = "ContactDB";
    public static final int DB_VERSION = 1;
    private static Context mContext;

    private static final String COMMAD_CREATE_CONTACT_TABLE =
            "CREATE TABLE  " + InfoContactDatabase.ContactEntry.TABLE_NAME +
                    " ( " + InfoContactDatabase.ContactEntry._ID +
                    " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , " +
                    InfoContactDatabase.ContactEntry.COLUMN_NAME +
                    " TEXT DEFAULT \"\", " +
                    InfoContactDatabase.ContactEntry.COLUMN_PHONE +
                    " TEXT DEFAULT \"\", " +
                    InfoContactDatabase.ContactEntry.COLUMN_ADDRESS +
                    " TEXT DEFAULT \"\")";

    private static final String COMMAND_DROP_CONTACT_TABLE =
            "DROP TABLE " + InfoContactDatabase.ContactEntry.TABLE_NAME;


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COMMAD_CREATE_CONTACT_TABLE);
        Toast.makeText(mContext, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // del previous database version's table
        db.execSQL(COMMAND_DROP_CONTACT_TABLE);

        // create new database's table
        db.execSQL(COMMAD_CREATE_CONTACT_TABLE);
        Toast.makeText(mContext, "onUpgrade", Toast.LENGTH_SHORT).show();
    }
}
