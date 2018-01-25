package com.example.tmd.qrcode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import static com.example.tmd.qrcode.MainActivity.INTENT_STRING;

public class GenerateQrCode extends AppCompatActivity {
    private String mString;
    private ImageView mPlaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr_code);
        mPlaceHolder = (ImageView) findViewById(R.id.image_view);
        receiveIntent();
        generateQrCode();
    }

    private void generateQrCode() {
        if (mString == null || mString.isEmpty()) {
            return;
        }
        Bitmap qrBitmap = net.glxn.qrgen.android.QRCode.from(mString).bitmap();
        mPlaceHolder.setImageBitmap(qrBitmap);
    }

    private void receiveIntent() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        mString = intent.getStringExtra(INTENT_STRING);
    }
}
