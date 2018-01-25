package com.example.tmd.permission_p;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*
        - Permission:
            + Các permission không thuộc loại dangerous thì chỉ cần khai báo trong AndroidManifest là được.
                Các permission thuộc loại dangerous thì phải khai báo trong AndroidManifest
            + Các máy < 6.0: không xuất hiện hộp thoại runtime requestPermissions mà nó chấp nhận luôn
            + Các máy >= 6.0: phải xác nhận lại trong hộp thoại runtime requestPermissions
    */

    private String TAG = "MainActivity";
    private static int REQUEST_PICK_IMAGE = 1;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button_select_image);
        mButton.setOnClickListener(this);
    }


    public void getImage() {
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DISPLAY_NAME};
        Cursor cursor = getContentResolver()
                .query(uri, projection, null, null, null);
        String str = "";
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MediaStore.Images.Media._ID));
                String name = cursor.getString(
                        cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
                str += "selectImage" + id + " _ name " + name + "\n";
            } while (cursor.moveToNext());
            cursor.close();
            mButton.setText(str);
        }
    }

    public void requestPermission() {
        // kiem tra xem app da duoc user cap quyen hay chua
        int isGrant = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        if (isGrant == PackageManager.PERMISSION_GRANTED) {
            // da duoc cap quyen
            getImage();
            Toast.makeText(this, "PERMISSION_GRANTED", Toast.LENGTH_SHORT).show();
        } else if (isGrant == PackageManager.PERMISSION_DENIED) {
            // chua duoc cap quyen
            // de bat su kien khi ng dung allow thi phai override onRequestPermissionsResult

            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // Trường hợp này là cần show 1 lời giải thích tới user
                // là tại sao mình cần truy cập quyền này
                AlertDialog.Builder aBuiler = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Request Image Permission")
                        .setMessage("We want to access to your external storage to get image and update avatar")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(
                                        MainActivity.this,
                                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                        REQUEST_PICK_IMAGE);
                            }
                        })
                        .setNegativeButton("NO", null);
                aBuiler.create().show();
            } else {
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_PICK_IMAGE);
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PICK_IMAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // user vua moi cap quyen
                getImage();
                Toast.makeText(this, "PERMISSION_GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                // user khong cap quyen
                Toast.makeText(this, "PERMISSION_DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        requestPermission();
    }
}
