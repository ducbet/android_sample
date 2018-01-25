package com.example.tmd.activity_p.implicitIntent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.tmd.activity_p.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class camera extends AppCompatActivity {

    /*
        - Yêu cầu thiết bị phải có camera:
            <uses-feature android:name="android.hardware.camera"
                          android:required="true" />
            + android:required="true" -> các thiết bị không có camera sẽ không thể download được từ Google Play
            + android:required="false" thì có thể download được nhưng khi run thì phải kiểm tra bằng:
                PackageManager packageManager = this.getPackageManager();
                hasSystemFeature(PackageManager.FEATURE_CAMERA)
                boolean boo = packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA);
        - Full-size Photo được lưu vào:
            + public external storage (các ứng dụng đều dùng được):
                    getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            + private (chỉ ứng dụng này dùng được->không lưu vào garelly được):
                    getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            -> Để truy cập thì phải yêu cầu READ_EXTERNAL_STORAGE (mặc định) & WRITE_EXTERNAL_STORAGE
                <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
            * Khi xóa ứng dụng, các file đã lưu cũng sẽ bị xóa
        - Video được lưu vào garelly khi gọi startActivityForResult luôn???

    */

    Button btnCapImage, btnRecordVideo;
    ImageView imgCapturedImage;
    VideoView vidRecordedVideo;
    MediaController mediaController;
    private String mCurrentPhotoPath;

    static final int REQUEST_IMAGE_CAPTURE = 1;// Trường hợp không cần lưu lại full-sized photo mà chỉ cần Thumbnail
    static final int REQUEST_TAKE_PHOTO = 2;// Trường hợp lưu lại full-sized photo
    static final int REQUEST_VIDEO_CAPTURE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        addControls();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Trường hợp không cần lưu lại full-sized photo mà chỉ cần Thumbnail
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();//getExtras() sẽ trả lại tất cả những gì đã đc putExtras rồi gói vào bundle
            Bitmap bitmap = (Bitmap) bundle.get("data");// key mặc định là "data"
            imgCapturedImage.setVisibility(View.VISIBLE);
            vidRecordedVideo.setVisibility(View.INVISIBLE);
            imgCapturedImage.setImageBitmap(bitmap);
        }
        // Trường hợp lưu lại full-sized photo
        else if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            addPicIntoGallery();
            imgCapturedImage.setVisibility(View.VISIBLE);
            vidRecordedVideo.setVisibility(View.INVISIBLE);

            // 2 cách lấy ảnh:
            {// C1:
//                Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath);
//                imgCapturedImage.setImageBitmap(bitmap);
            }
            {// C2:
                Glide.with(this)
                        .load(mCurrentPhotoPath)
                        .error(R.drawable.error)// load anh nay neu download loi
                        .placeholder(R.mipmap.ic_launcher)// cac anh hien thi trong luc dang download
                        .into(imgCapturedImage);
            }
        }
        // Video được lưu vào garelly khi gọi startActivityForResult luôn???
        else if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            imgCapturedImage.setVisibility(View.INVISIBLE);
            vidRecordedVideo.setVisibility(View.VISIBLE);
            Uri videoUri = data.getData();
            vidRecordedVideo.setVideoURI(videoUri);
            vidRecordedVideo.start();
        }
    }

    public void capImage(View view) {
        if (hasCamera()) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//                {// only get a Thumbnail
//                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//                }
                {// get picture full sized
                    // tạo 1 file để nhét photo vừa chụp được vào
                    File photoFile = null;
                    try {
                        photoFile = createImageFile();
                    } catch (IOException e) {
                        // show error, log,...
                    }
                    // nếu tạo được thì tiếp tục
                    if (photoFile != null) {
                        Uri photoURI = Uri.fromFile(photoFile);
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                    }
                }
            }
        }
    }

    public void recordVideo(View view) {
        if (hasCamera()) {
            Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
            }
        }
    }

    private void addPicIntoGallery() {
        // Ném ảnh vào Garelly // chỉ dùng khi ảnh được lưu vào public external storage
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    File createImageFile() throws IOException {
        // Tạo ảnh với tên chứa thời gian chụp (để tránh trùng tên)
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + ".jpg";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        mCurrentPhotoPath = storageDir.getAbsolutePath() + "/" + imageFileName;
        // /storage/emulated/0/Pictures/JPEG_20170425_155955.jpg
        System.out.println(mCurrentPhotoPath + "");
        File image = new File(mCurrentPhotoPath);
        return image;
    }

    private boolean hasCamera() {
        PackageManager packageManager = this.getPackageManager();
        boolean TF = packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA);
        if (TF) {
            Toast.makeText(this, "DEVICE HAS CAMERA", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "DEVICE NOT HAVE CAMERA", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    private void addControls() {
        btnCapImage = (Button) findViewById(R.id.btnCapImage);
        btnRecordVideo = (Button) findViewById(R.id.btnRecordVideo);
        imgCapturedImage = (ImageView) findViewById(R.id.imgCapturedImage);
        imgCapturedImage.setVisibility(View.INVISIBLE);

        vidRecordedVideo = (VideoView) findViewById(R.id.vidRecordedVideo);
        vidRecordedVideo.setVisibility(View.INVISIBLE);
        //Creating MediaController
        mediaController = new MediaController(this);
        mediaController.setAnchorView(vidRecordedVideo);
        //Setting MediaController
        vidRecordedVideo.setMediaController(mediaController);
    }
}
