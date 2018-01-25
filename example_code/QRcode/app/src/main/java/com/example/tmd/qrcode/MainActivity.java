package com.example.tmd.qrcode;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CAMERA = 123;
    public static final String INTENT_STRING = "INTENT_STRING";
    private SurfaceView mSurfaceView;
    private TextView mTextViewShowQrCode;
    private SparseArray<Barcode> mBarcodeSparseArray;
    private BarcodeDetector mBarcodeDetector;
    private CameraSource mCameraSource;
    private Object mQrCode;
    //
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSurfaceView = (SurfaceView) findViewById(R.id.surface_view);
        mTextViewShowQrCode = (TextView) findViewById(R.id.text_view_show_QR_code);
        findViewById(R.id.button).setOnClickListener(this);
        mEditText = (EditText) findViewById(R.id.edit_text);
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (keyEvent != null && ((i == EditorInfo.IME_ACTION_DONE
                    || keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER))) {
                    openGenerateQrCode();
                    return true;
                }
                return false;
            }
        });
        requestPermission();
    }

    private void openGenerateQrCode() {
        Intent intent = new Intent(MainActivity.this, GenerateQrCode.class);
        intent.putExtra(INTENT_STRING, mEditText.getText().toString());
        startActivity(intent);
    }

    public void getQrCode() {
        mBarcodeDetector = new BarcodeDetector
            .Builder(this)
            .setBarcodeFormats(Barcode.QR_CODE)
            .build();
        if (!mBarcodeDetector.isOperational()) {
            mTextViewShowQrCode.setText("Can not detector QRcode");
            return;
        }
        mCameraSource = new CameraSource
            .Builder(this, mBarcodeDetector)
            .setAutoFocusEnabled(true)
            .build();
        mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                try {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission
                        .CAMERA) !=
                        PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    mCameraSource.start(mSurfaceView.getHolder());
                } catch (IOException e) {
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                mCameraSource.stop();
            }
        });
        mBarcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                mBarcodeSparseArray = detections.getDetectedItems();
                if (mBarcodeSparseArray.size() != 0) {
                    mTextViewShowQrCode.post(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewShowQrCode
                                .setText(mBarcodeSparseArray.valueAt(0).displayValue);
                        }
                    });
                }
            }
        });
    }

    public void requestPermission() {
        boolean isGrant = ContextCompat.checkSelfPermission(MainActivity.this,
            Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
        if (isGrant) {
            getQrCode();
            return;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
            Manifest.permission.CAMERA)) {
            AlertDialog.Builder aBuiler = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Request camera")
                .setMessage("Request camera")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            REQUEST_CAMERA);
                    }
                })
                .setNegativeButton("NO", null);
            aBuiler.create().show();
            return;
        }
        ActivityCompat.requestPermissions(
            MainActivity.this,
            new String[]{Manifest.permission.CAMERA},
            REQUEST_CAMERA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CAMERA) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getQrCode();
            } else {
                Toast.makeText(this, "REQUEST PERMISSION DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCameraSource.release();
        mBarcodeDetector.release();
    }

    @Override
    public void onClick(View view) {
        openGenerateQrCode();
    }
}
