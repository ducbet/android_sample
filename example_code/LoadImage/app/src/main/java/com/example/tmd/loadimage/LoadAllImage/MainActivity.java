package com.example.tmd.loadimage.LoadAllImage;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.tmd.loadimage.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MyImage> mList;
    private ImageAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private static int REQUEST_PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
    }

    private void addControls() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_image);
        mList = new ArrayList<MyImage>();
        requestPermission();// request and get image

        mAdapter = new ImageAdapter(this, mList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(mAdapter);
    }



    private void loadImageFromExternalStoges() {
        String imagePath;
        String imageName;

        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        // C1:
        // lấy đường dẫn chứa ảnh
//        File[] listImage = storageDir.listFiles();
//        for (File f : listImage) {
//            System.out.println(f.getAbsolutePath());
//            mList.add(new MyImage(f.getAbsolutePath()));
//        }


        // C2: Em không hiểu sao dùng cách này lại có nhiều ảnh thế :/
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                // imageName = tên file ảnh
                imageName = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
                // imagePath = đường dẫn/tên file ảnh
                imagePath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));//*
                String path1 = imagePath;
                String path2 = storageDir + "/" + imageName;

                // 2 cách lấy, cách lấy DISPLAY_NAME là sai. Phải lấy thẳng DATA luôn
                System.out.println("--------------\n" + path1);
                System.out.println(path2);
                System.out.println("path1.equals(path2): " + path1.equals(path2));

                mList.add(new MyImage(imagePath));
//                mList.add(new MyImage(storageDir + "/" + imageName));// sai // 1 số imageName sẽ khác
            } while (cursor.moveToNext());
            cursor.close();
        }
    }

    public void requestPermission() {
        // kiem tra xem app da duoc user cap quyen hay chua
        int isGrant = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (isGrant == PackageManager.PERMISSION_GRANTED) {
            // da duoc cap quyen
            loadImageFromExternalStoges();
            Toast.makeText(this, "PERMISSION_GRANTED", Toast.LENGTH_SHORT).show();
        } else if (isGrant == PackageManager.PERMISSION_DENIED) {
            // chua duoc cap quyen
            // de bat su kien khi ng dung allow thi phai override onRequestPermissionsResult

            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Trường hợp này là cần show 1 lời giải thích tới user
                // là tại sao mình cần truy cập quyền này
                AlertDialog.Builder aBuiler = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Request Image Permission")
                        .setMessage("We want to access to your external storage to get image")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(
                                        MainActivity.this,
                                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                        REQUEST_PICK_IMAGE);
                            }
                        })
                        .setNegativeButton("NO", null);
                aBuiler.create().show();
            } else {
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
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
                loadImageFromExternalStoges();
                Toast.makeText(this, "PERMISSION_GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                // user khong cap quyen
                Toast.makeText(this, "PERMISSION_DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
