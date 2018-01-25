package com.example.tmd.optionmenu_p.BTVN;

import android.provider.BaseColumns;

/**
 * Created by tmd on 17/04/2017.
 */

public class ContactContract {

    public class ContactEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_contact";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_ADDRESS = "address";

    }

}
