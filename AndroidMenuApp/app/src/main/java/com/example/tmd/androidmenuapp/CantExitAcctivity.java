package com.example.tmd.androidmenuapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CantExitAcctivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTittleBar();
        setContentView(R.layout.activity_cant_exit_acctivity);

        mTextView = (TextView) findViewById(R.id.text_view_cant_exit);

        final Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 2000ms
                mTextView.setText("Vẫn chưa thoát được đâu =))");
            }
        }, 2000);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 4000ms
                finish();
            }
        }, 4000);
    }

    public void removeTittleBar() {
        //remove title bar,..//phai de truoc setContentView(R.layout.activity_animation);

        getSupportActionBar().hide();//hide Title Bar (tên application)

        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //hide Navigation Bar (thanh dưới cùng)
                | View.SYSTEM_UI_FLAG_FULLSCREEN //hide Status Bar (thanh trên cùng)
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY; // quay trở lại trạng thái ẩn nếu không chạm nữa
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void returnMainActivity(View view) {
        finish();
    }
}
