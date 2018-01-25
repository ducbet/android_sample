package com.example.tmd.loadimage;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class UserChooseImage extends AppCompatActivity implements View.OnClickListener {
    /*
        - Cho người dùng chọn ảnh nên không cần yêu cầu permission
        -
    */

    private Button mButton;
    private ImageView mImageView;
    private static final int REQUEST_PICK_IMAGE = 1;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choose_image);

        addControls();
        addEvents();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PICK_IMAGE && resultCode == RESULT_OK) {
            Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
            Uri uri = data.getData();
            Glide.with(this)
                    .load(uri)
                    .error(R.drawable.error)// load anh nay neu download loi
                    .placeholder(R.mipmap.ic_launcher)// cac anh hien thi trong luc dang download
                    .into(mImageView);
        }
    }

    private void addEvents() {
        mButton.setOnClickListener(this);
    }

    private void addControls() {
        mButton = (Button) findViewById(R.id.button_select_image);
        mImageView = (ImageView) findViewById(R.id.image_view_gau_cuong);
    }
}
