package com.example.tmd.eventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tmd.eventhandling.R;

public class viewSubclassing extends AppCompatActivity {

    /*
        - Khó + ít dùng => chưa code
        - Dùng cho những View xuất hiện trong khi app đang chạy
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_subclassing);
    }
}
