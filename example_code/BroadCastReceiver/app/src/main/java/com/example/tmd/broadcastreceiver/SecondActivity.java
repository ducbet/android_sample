package com.example.tmd.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String ACTION_FINISH = "com.example.tmd.broadcastreceiver.action.FINISH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.button_stop).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction(ACTION_FINISH);
        sendBroadcast(intent);
    }
}
