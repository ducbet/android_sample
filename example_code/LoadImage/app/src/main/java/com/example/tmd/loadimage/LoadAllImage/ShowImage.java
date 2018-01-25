package com.example.tmd.loadimage.LoadAllImage;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tmd.loadimage.R;

public class ShowImage extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        mImageView = (ImageView) findViewById(R.id.image_view_show_image);

        Intent intent = getIntent();
        String imagePath = intent.getStringExtra("IMAGE_PATH");
        showImage(imagePath);
    }

    private void showImage(String imagePath) {
        Glide.with(this)
                .load(imagePath)
                .error(R.drawable.error)// load anh nay neu download loi
                .placeholder(R.drawable.wait)// cac anh hien thi trong luc dang download
                .into(mImageView);
    }


}
