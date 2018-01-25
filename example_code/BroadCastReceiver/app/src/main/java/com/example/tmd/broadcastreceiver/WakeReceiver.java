package com.example.tmd.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by tmd on 04/05/2017.
 */

public class WakeReceiver extends BroadcastReceiver {
    private static final String TAG = "TAG";
    private OnReceiverListener mListener;

    // TODO: 04/05/2017 2
    public WakeReceiver(OnReceiverListener listener) {
        mListener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "WakeupReceiver", Toast.LENGTH_SHORT).show();
        switch (intent.getAction()) {
            case Intent.ACTION_SCREEN_ON:
                Log.d(TAG, "onReceive: ACTION_SCREEN_ON");
                // TODO: 04/05/2017 3
                mListener.onScreenOn(intent);
                break;
            case Intent.ACTION_SCREEN_OFF:
                Log.d(TAG, "onReceive: ACTION_SCREEN_OFF");
                mListener.onScreenOff(intent);
                break;
            case SecondActivity.ACTION_FINISH:
                mListener.onFinish(intent);
                break;
            default:
                break;
        }
    }

    // truyền sự kiện, khai báo 1 interface
    interface OnReceiverListener {
        // TODO: 04/05/2017 1
        void onScreenOn(Intent intent);

        void onScreenOff(Intent intent);

        void onFinish(Intent intent);

        void onDoSomeThing(Intent intent);
    }
}
