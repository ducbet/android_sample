package com.example.tmd.test_del;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TABLE_2_PERSON = "TABLE_2_PERSON";
    public static final String TABLE_4_PERSON = "TABLE_4_PERSON";
    public static final String TABLE_8_PERSON = "TABLE_8_PERSON";
    public static final int[] TABLE_2_PERSON_SIZE = {150, 150};
    public static final int[] TABLE_4_PERSON_SIZE = {200, 200};
    public static final int[] TABLE_8_PERSON_SIZE = {250, 750};
    public static final int TABLE_2_PERSON_IMAGE = R.drawable.ban2;
    public static final int TABLE_4_PERSON_IMAGE = R.drawable.ban4;
    public static final int TABLE_8_PERSON_IMAGE = R.drawable.ban8;
    private List<AwesomeTable> mTables;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createTables();
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);
        bindTables();
    }

    private void bindTables() {
        for (AwesomeTable table : mTables) {
            Log.e("MY_TAG", "bindTables: ");
            ImageAwesomeTable imageAwesomeTable = new ImageAwesomeTable(this, table);
            mRelativeLayout.addView(imageAwesomeTable);
        }
    }

    private void createTables() {
        mTables = new ArrayList<>();
        mTables.add(new AwesomeTable(300, 300, TABLE_2_PERSON));
        mTables.add(new AwesomeTable(500, 500, TABLE_4_PERSON));
        mTables.add(new AwesomeTable(0, 0, TABLE_8_PERSON));
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}
