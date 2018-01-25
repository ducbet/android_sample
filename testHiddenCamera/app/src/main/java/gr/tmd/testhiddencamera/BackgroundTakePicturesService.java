package gr.tmd.testhiddencamera;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.androidhiddencamera.CameraConfig;
import com.androidhiddencamera.CameraError;
import com.androidhiddencamera.HiddenCameraService;
import com.androidhiddencamera.HiddenCameraUtils;
import com.androidhiddencamera.config.CameraFacing;
import com.androidhiddencamera.config.CameraImageFormat;
import com.androidhiddencamera.config.CameraResolution;

import java.io.File;

import static gr.tmd.testhiddencamera.MainActivity.IS_WALKING;

/**
 * Created by tmd on 1/3/18.
 */
public class BackgroundTakePicturesService extends HiddenCameraService {

    private CameraConfig mCameraConfig;

    private Handler mHandler = new Handler();
    private Runnable runnableTakePictureIfWalking = new Runnable() {
        @Override
        public void run() {
            if (IS_WALKING) {
                takePicture();
            }
        }
    };

    File createImageFile() {
        String imageName = "JPEG_HIDDEN_CAMERA.jpg";
        File storageDir =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String currentPhotoPath = storageDir.getAbsolutePath() + "/" + imageName;
        // currentPhotoPath= /storage/emulated/0/Pictures/JPEG_HIDDEN_CAMERA.jpg
        return new File(currentPhotoPath);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("MY_TAG", "onStartCommand");
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==
            PackageManager.PERMISSION_GRANTED) {
            if (HiddenCameraUtils.canOverDrawOtherApps(this)) {
                if (mCameraConfig == null) {
                    Log.e("MY_TAG", "init mCameraConfig");
                    Toast.makeText(this, "init mCameraConfig", Toast.LENGTH_SHORT).show();
                    mCameraConfig = new CameraConfig()
                        .getBuilder(this)
                        .setCameraFacing(CameraFacing.REAR_FACING_CAMERA)
                        .setCameraResolution(CameraResolution.HIGH_RESOLUTION)
                        .setImageFormat(CameraImageFormat.FORMAT_JPEG)
                        .setImageFile(createImageFile())
                        .build();
                    startCamera(mCameraConfig);
                }
                mHandler.postDelayed(runnableTakePictureIfWalking, 1000);
            } else {
                //Open settings to grant permission for "Draw other apps".
                HiddenCameraUtils.openDrawOverPermissionSetting(this);
            }
        } else {
            //TODO Ask your parent activity for providing runtime permission
            Toast.makeText(this, "Camera permission not available", Toast.LENGTH_SHORT).show();
        }
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onImageCapture(@NonNull File imageFile) {
//        Log.e("MY_TAG", "onImageCapture");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);
        //Do something with the bitmap

        // do not stop service after take picture
//        stopSelf();
        runnableTakePictureIfWalking.run();
    }

    @Override
    public void onCameraError(@CameraError.CameraErrorCodes int errorCode) {
        switch (errorCode) {
            case CameraError.ERROR_CAMERA_OPEN_FAILED:
                //Camera open failed. Probably because another application
                //is using the camera
                break;
            case CameraError.ERROR_IMAGE_WRITE_FAILED:
                //Image write failed. Please check if you have provided WRITE_EXTERNAL_STORAGE permission
                break;
            case CameraError.ERROR_CAMERA_PERMISSION_NOT_AVAILABLE:
                //camera permission is not available
                //Ask for the camera permission before initializing it.
                break;
            case CameraError.ERROR_DOES_NOT_HAVE_OVERDRAW_PERMISSION:
                //Display information dialog to the user with steps to grant "Draw over other app"
                //permission for the app.
                HiddenCameraUtils.openDrawOverPermissionSetting(this);
                break;
            case CameraError.ERROR_DOES_NOT_HAVE_FRONT_CAMERA:
                break;
        }
        stopSelf();
    }
}
