package com.example.tmd.sqlite_db.SQLite_DB.ContactCopyFromAssests;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * Created by tmd on 29/04/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static Context mContext;
    public static final String DB_NAME = "ContactDB.sqlite";
    public static final int DB_VERSION = 1;
    protected final String TAG = "TAG";

    public DatabaseHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
        Log.d(TAG, "DB_NAME: " + DB_NAME + ",DB_VERSION: " + DB_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");
        CopyDatabaseFromAssets();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);

    }

    private void CopyDatabaseFromAssets() {

        try {
            // get InputStream
            InputStream inputStream = mContext.getAssets().open(DB_NAME);


            // kiểm tra xem có folder databases chưa (lần đầu tiên chạy thì chưa tồn tại)
            File file = new File(mContext.getApplicationInfo().dataDir + "/databases/");
            if (!file.exists()) {
                // chưa có folder databases => tạo
                file.mkdir();
            }
            // get OutputStream
            String outputFileName = getDatabasePath();
            OutputStream outputStream = new FileOutputStream(outputFileName);
            // copy
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer);
//                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getDatabasePath() {
        return mContext.getApplicationInfo().dataDir + "/databases/" + DB_NAME;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // del previous database version
        mContext.deleteDatabase(DB_NAME);
        // create new database
        CopyDatabaseFromAssets();
        Log.d(TAG, "onUpgrade");
    }
}
