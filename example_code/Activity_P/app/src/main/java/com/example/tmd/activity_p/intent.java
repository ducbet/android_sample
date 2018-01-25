package com.example.tmd.activity_p;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.tmd.activity_p.R;

public class intent extends AppCompatActivity {

    /*
        - Có 3 kiểu mở 1 activity:
            + Mở nhưng không gửi dữ liệu
            + Mở và truyền dữ liệu (làm ở appLifeCycle.FloatingWindow)
            + Mở, truyền dữ liệu, quan tâm dữ liệu trả về (làm ở appLifeCycle.FullScreenWindow)
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }

    public void openAppLifeCycle(View view) {
        Intent intent = new Intent(this, appLifeCycle.class);
        startActivity(intent);
    }
}
