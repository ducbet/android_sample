package com.example.tmd.loadimage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tmd.loadimage.R;

public class LoadImageFromInternet extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_INTERNET = 1;

    /*
        - Sử dụng thư viện Glide (cần phải add compile 'com.github.bumptech.glide:glide:3.7.0')

        - Permission:
            + Các permission không thuộc loại dangerous thì chỉ cần khai báo trong AndroidManifest là được.
                Các permission thuộc loại dangerous thì phải khai báo trong AndroidManifest
            + Các máy < 6.0: không xuất hiện hộp thoại requestPermissions at runtime mà nó chấp nhận luôn
            + Các máy >= 6.0: phải xác nhận lại trong hộp thoại requestPermissions at runtime
    */

    private Button mButton;
    private ImageView mImageView;
    private String url = "http://ext.fmkorea.com/files/attach/images/1121272/829/876/063/9aede3d2d42cc42768a6348e91a39901.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image_from_internet);

        addControls();
        addEvents();
    }

    private void addEvents() {
        mButton.setOnClickListener(this);
    }

    private void addControls() {
        mButton = (Button) findViewById(R.id.button_select_image);
        mImageView = (ImageView) findViewById(R.id.image_view_gau_cuong);
    }

    @Override
    public void onClick(View v) {
        requestPermission();

    }

    private void requestPermission() {
        int isGrand = ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET);
        if (isGrand == PackageManager.PERMISSION_GRANTED) {
            loadImage();
        } else {
            Toast.makeText(this, "INTERNET: PERMISSION_DENIED", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.INTERNET},
                    REQUEST_INTERNET);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_INTERNET) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadImage();
            }
        }
    }

    private void loadImage() {
        Glide.with(this)
                .load(url)
                .error(R.drawable.error)// load anh nay neu download loi
                .placeholder(R.mipmap.ic_launcher)// cac anh hien thi trong luc dang download
                .into(mImageView);
    }
}
