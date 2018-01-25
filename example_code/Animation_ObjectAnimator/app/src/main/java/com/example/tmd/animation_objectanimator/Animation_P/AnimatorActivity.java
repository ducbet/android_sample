package com.example.tmd.animation_objectanimator.Animation_P;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tmd.animation_objectanimator.R;

public class AnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    // 7" devices
    /*

        - Goc toa do cua Animator la View truoc khi animate,
            VD: DOWN: 0, 400
                RIGHT: 0, 300
                UP: 100, 0
                thi no khi UP no se nhay len 300 roi moi UP 100 de ve truc x ban dau

        - property (ObjectAnimator)
                    translationX
            translationY
                    rotation
            rotationX
                    rotationY
            scaleX
                    scaleY
            pivotX
                    pivotY
            x
                    y
            alpha
    */
    public static final int DURATION = 1000;
    public static final float maxLeft = getScreenWidth() - convertDpToPixel(100);
    public static final float maxBottom = getScreenHeight() - convertDpToPixel(100);//dung khi fullscreen

    private ImageView imgCar;
    private boolean isCarRunning = false;
    private AnimatorSet objectAnimatorSet = new AnimatorSet();

    private Point topLeftScreeen, topRightScreen, bottomLeftScreen, bottomRightScreen;
    private Point carNowPosition, carToPosition;

    private static final int DOWN = 0, RIGHT = 1, UP = 2, LEFT = 3;
    private int carDirection = DOWN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTittleBar();
        setContentView(R.layout.activity_animator);

        addControls();
        setValue();
        addEvents();
        setCarRun();// chỉ cho AnimatorSet objectAnimatorSet.start(); 1 lần

    }


    public ObjectAnimator setObjectAnimatorCarRun(Point carToCorner) {

        float needGo;
        ObjectAnimator carRunAnimor = new ObjectAnimator();
        carRunAnimor.setInterpolator(new AccelerateDecelerateInterpolator());
        if (carDirection == DOWN) {
            needGo = carToCorner.getY() - 2 * convertDpToPixel(100);
            carRunAnimor = ObjectAnimator.ofFloat(imgCar, "translationY", 0, needGo);
        } else if (carDirection == UP) {
            needGo = carNowPosition.getY() - 2 * convertDpToPixel(100);
            carRunAnimor = ObjectAnimator.ofFloat(imgCar, "translationY", needGo, 0);
        } else if (carDirection == LEFT) {
            needGo = carNowPosition.getX() - 2 * convertDpToPixel(100);
            carRunAnimor = ObjectAnimator.ofFloat(imgCar, "translationX", needGo, 0);
        } else {
            needGo = carToCorner.getX() - 2 * convertDpToPixel(100);
            carRunAnimor = ObjectAnimator.ofFloat(imgCar, "translationX", 0, needGo);
        }

        carRunAnimor.setDuration(DURATION);
        carNowPosition = carToCorner;
        carDirection = (++carDirection) % 4;
        return carRunAnimor;
    }

    public void setCarRun() {//carRun = code, carTurn = xml
        Animator amorTurn = null;
        int i;
        for (i = 0; i < 500; i++) {
            ObjectAnimator carAnimor = setObjectAnimatorCarRun(carToCorner(carNowPosition));
            if (i == 0) {
                objectAnimatorSet.play(carAnimor);
                amorTurn = AnimatorInflater.loadAnimator(this, R.animator.animator_rotate_left_bottom_left);
                amorTurn.setTarget(imgCar);
                objectAnimatorSet.play(carAnimor).before(amorTurn);
            } else if (i % 4 == 0) {//turn left at bottomLeftScreen
                objectAnimatorSet.play(amorTurn).before(carAnimor);
                amorTurn = AnimatorInflater.loadAnimator(this, R.animator.animator_rotate_left_bottom_left);
                amorTurn.setTarget(imgCar);
                objectAnimatorSet.play(carAnimor).before(amorTurn);
            } else if (i % 4 == 1) {//turn left at bottomRightScreen
                objectAnimatorSet.play(amorTurn).before(carAnimor);
                amorTurn = AnimatorInflater.loadAnimator(this, R.animator.animator_rotate_left_bottom_right);
                amorTurn.setTarget(imgCar);
                objectAnimatorSet.play(carAnimor).before(amorTurn);
            } else if (i % 4 == 2) {//turn left at topRightScreen
                objectAnimatorSet.play(amorTurn).before(carAnimor);
                amorTurn = AnimatorInflater.loadAnimator(this, R.animator.animator_rotate_left_top_right);
                amorTurn.setTarget(imgCar);
                objectAnimatorSet.play(carAnimor).before(amorTurn);
            } else if (i % 4 == 3) {//turn left at topLeftScreen
                objectAnimatorSet.play(amorTurn).before(carAnimor);
                amorTurn = AnimatorInflater.loadAnimator(this, R.animator.animator_rotate_left_top_left);
                amorTurn.setTarget(imgCar);
                objectAnimatorSet.play(carAnimor).before(amorTurn);
            }
        }
        objectAnimatorSet.start();
        isCarRunning = true;
    }


    public Point carToCorner(Point carNowPosition) {
        if (carNowPosition.pointEquals(topLeftScreeen))
            return bottomLeftScreen;
        else if (carNowPosition.pointEquals(topRightScreen))
            return topLeftScreeen;
        else if (carNowPosition.pointEquals(bottomLeftScreen))
            return bottomRightScreen;
        else if (carNowPosition.pointEquals(bottomRightScreen))
            return topRightScreen;
        return null;//khong bao gio xay ra//nhung khong co thi error -_-
    }

    public void setValue() {
        topLeftScreeen = new Point(0, 0);
        topRightScreen = new Point(maxLeft, 0);
        bottomLeftScreen = new Point(0, maxBottom);
        bottomRightScreen = new Point(maxLeft, maxBottom);
        carNowPosition = new Point(topLeftScreeen);
    }

    private void addControls() {
        imgCar = (ImageView) findViewById(R.id.image_view_car);

    }

    private void addEvents() {
        imgCar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == imgCar) {
            if (isCarRunning) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    objectAnimatorSet.pause();
                    isCarRunning = false;
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    objectAnimatorSet.resume();
                    isCarRunning = true;
                }
            }
        }
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public void removeTittleBar() {
        //remove title bar,..//phai de truoc setContentView(R.layout.activity_animation);

        getSupportActionBar().hide();//hide Title Bar (tên application)

        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //hide Navigation Bar (thanh dưới cùng)
                | View.SYSTEM_UI_FLAG_FULLSCREEN //hide Status Bar (thanh trên cùng)
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY; // quay trở lại trạng thái ẩn nếu không chạm nữa
        decorView.setSystemUiVisibility(uiOptions);
    }
}
