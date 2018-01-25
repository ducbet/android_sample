package com.example.tmd.sqlite_db.SQLite_DB;

import android.provider.BaseColumns;

/**
 * Created by tmd on 23/04/2017.
 */

public class InfoContactDatabase {
    public class ContactEntry implements BaseColumns {
        public static final String TABLE_NAME = "Contact";
        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_PHONE = "Phone";
        public static final String COLUMN_ADDRESS = "Address";
    }
}
