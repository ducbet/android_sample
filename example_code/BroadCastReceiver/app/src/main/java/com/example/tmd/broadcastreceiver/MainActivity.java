package com.example.tmd.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WakeReceiver.OnReceiverListener, View.OnClickListener {

    private static final String TAG = "TAG";
    private WakeReceiver mWakeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 04/05/2017 4
        mWakeReceiver = new WakeReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(SecondActivity.ACTION_FINISH);
        // dang ky
        registerReceiver(mWakeReceiver, intentFilter);

        findViewById(R.id.button_start_new).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // bat buoc phai huy
        unregisterReceiver(mWakeReceiver);
    }

    @Override
    public void onScreenOn(Intent intent) {
        Log.d(TAG, "MainActivity: onScreenOn: ");
    }

    @Override
    public void onScreenOff(Intent intent) {
        Log.d(TAG, "MainActivity: onScreenOff: ");
    }

    @Override
    public void onFinish(Intent intent) {
        finish();
    }

    @Override
    public void onDoSomeThing(Intent intent) {

    }


}
