package com.example.tmd.animation_objectanimator.Animation_P;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.tmd.animation_objectanimator.R;


public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    // 7" devices
    /*
        - Goc toa do cua Animation la View, neu dat trong AnimationSet thi la Draw cuoi cung
        - Có 2 cách khởi tạo
            + C1: Dùng file xml
                + B1: Tạo file resource trong anim.
                + B2: Load animation: Animation animN = AnimationUtils.loadAnimation(this, R.anim.anim_name);
                + B3: Start animation với 1 view cụ thể: v.startAnimation(animiewNameName);
            + C2: Code (example: ball)

        - Muốn thực hiện gì khi start/end/repeat animation thì dùng listener
            + animName.setAnimationListener(new Animation.AnimationListener(){...});
    */

    public static final int DURATION = 1000;
    //can truyen pixels vao TranslateAnimation(); getScreenWidth() return pixels nhung kick thuoc ball = 100dp nen phai convert
    public static final float maxLeft = getScreenWidth() - convertDpToPixel(100);
    public static final float maxBottom = getScreenHeight() - convertDpToPixel(100);//dung khi fullscreen

    private RelativeLayout relativeLayout;
    private Button btnFadeIn, btnFadeOut, btnRepeat, btnZoomIn, btnZoomOut;
    private Button btnMoveUp, btnMoveDown, btnMoveLeft, btnMoveRight;
    private Button btnSequence, btnSameTime, btnRotate;

    private ImageView imgBall, imgFly, imgGhost;

    private AnimationSet animationSet = new AnimationSet(true);
    private Animation animFadeIn, animFadeOut, animRepeat, animZoomIn, animZoomOut;
    private Animation animMoveUp, animMoveDown, animMoveLeft, animMoveRight;
    private Animation animSequence, animSameTime, animRotate, animRotateReverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTittleBar();
        setContentView(R.layout.activity_animation);

        addControls();
        loadAnimation();
        setBallAnimationSet();//ball chay quanh man hinh
        addEvents();
    }

    public TranslateAnimation createAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        TranslateAnimation animation = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        animation.setDuration(2 * DURATION);
//        animation.setFillAfter(false);
//        animation.setRepeatMode(REVERSE);
//        animation.setRepeatMode(RESTART);
//        animation.setRepeatCount(200);
        return animation;
    }

    public void setBallAnimationSet() {//ball chay quanh man hinh
        animationSet.setFillEnabled(true);
        animationSet.setFillAfter(true);//ball se o vi tri cuoi cung ma không quay ve vi tri truoc khi chay animation
        animationSet.setInterpolator(new BounceInterpolator());//mo phong ball roi xuong roi nay len

//set DURATION = 5000 cho de nhin
//        carRunAnimor.setInterpolator(new AccelerateDecelerateInterpolator());//An interpolator where the rate of change starts and ends slowly but accelerates through the middle.

//        carRunAnimor.setInterpolator(new AccelerateInterpolator());//An interpolator where the rate of change starts out slowly and and then accelerates.

//        carRunAnimor.setInterpolator(new AnticipateInterpolator());//An interpolator where the change starts backward then flings forward.

//        carRunAnimor.setInterpolator(new AnticipateOvershootInterpolator());//An interpolator where the change starts backward then flings forward and overshoots the target value and finally goes back to the final value.

//        carRunAnimor.setInterpolator(new BounceInterpolator());//An interpolator where the change bounces at the end.

//        carRunAnimor.setInterpolator(new CycleInterpolator(1.5f));//Repeats the animation for a specified number of cycles. The rate of change follows a sinusoidal pattern.

//        carRunAnimor.setInterpolator(new DecelerateInterpolator());//An interpolator where the rate of change starts out quickly and and then decelerates.

//        carRunAnimor.setInterpolator(new FastOutLinearInInterpolator());//Interpolator corresponding to fast_out_linear_in. Uses a lookup table for the Bezier curve from (0,0) to (1,1) with control points: P0 (0, 0) P1 (0.4, 0) P2 (1.0, 1.0) P3 (1.0, 1.0)

//        carRunAnimor.setInterpolator(new FastOutSlowInInterpolator());//Interpolator corresponding to fast_out_slow_in. Uses a lookup table for the Bezier curve from (0,0) to (1,1) with control points: P0 (0, 0) P1 (0.4, 0) P2 (0.2, 1.0) P3 (1.0, 1.0)

//        carRunAnimor.setInterpolator(new LinearInterpolator());//An interpolator where the rate of change is constant

//        carRunAnimor.setInterpolator(new LinearOutSlowInInterpolator());//Interpolator corresponding to linear_out_slow_in. Uses a lookup table for the Bezier curve from (0,0) to (1,1) with control points: P0 (0, 0) P1 (0, 0) P2 (0.2, 1.0) P3 (1.0, 1.0)

//        carRunAnimor.setInterpolator(new OvershootInterpolator());//An interpolator where the change flings forward and overshoots the last value then comes back.

        Point ballNowPosition = new Point(0, maxBottom);//phải để như thế này, vì trong vòng for đầu tiên nowX, nowY vẫn là 0, 0
        Point ballToPosition = new Point(0, maxBottom);

        int timeOffset, i;
        for (timeOffset = 0, i = 0; i < 500; timeOffset += 2.05 * DURATION, i++)//2.05*DURATION de dung lai 1 chut
        {
            TranslateAnimation animation = createAnimation(0, ballToPosition.getX(), 0, ballToPosition.getY());
            positionNext(ballNowPosition, ballToPosition);
            animation.setStartOffset(timeOffset);
            animationSet.addAnimation(animation);
        }
    }

    public void positionNext(Point nowPosition, Point toPosition) {
        if (nowPosition.getX() == 0 && nowPosition.getY() == 0) {
            toPosition.setX(0f);
            toPosition.setY(maxBottom);

            nowPosition.setX(0f);
            nowPosition.setY(maxBottom);
        } else if (nowPosition.getX() == 0f && nowPosition.getY() == maxBottom) {
            toPosition.setX(maxLeft);
            toPosition.setY(0f);

            nowPosition.setX(maxLeft);
            nowPosition.setY(maxBottom);
        } else if (nowPosition.getX() == maxLeft && nowPosition.getY() == maxBottom) {
            toPosition.setX(0f);
            toPosition.setY(-maxBottom);

            nowPosition.setX(maxLeft);
            nowPosition.setY(0f);
        } else if (nowPosition.getX() == maxLeft && nowPosition.getY() == 0) {
            toPosition.setX(-maxLeft);
            toPosition.setY(0f);

            nowPosition.setX(0f);
            nowPosition.setY(0f);
        }
    }


    private void addEvents() {
        btnFadeIn.setOnClickListener(this);
        btnFadeOut.setOnClickListener(this);
        btnRepeat.setOnClickListener(this);
        btnZoomIn.setOnClickListener(this);
        btnZoomOut.setOnClickListener(this);
        btnMoveUp.setOnClickListener(this);
        btnMoveDown.setOnClickListener(this);
        btnMoveLeft.setOnClickListener(this);
        btnMoveRight.setOnClickListener(this);
        btnSequence.setOnClickListener(this);
        btnSameTime.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnSequence.setOnClickListener(this);
        btnSameTime.setOnClickListener(this);

        imgBall.setOnClickListener(this);
        imgGhost.setOnClickListener(this);

        animRotateReverse.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!animationSet.hasStarted()) {
                    imgBall.startAnimation(animationSet);

                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == imgBall) {
            if (!animationSet.hasStarted()) {
                imgBall.startAnimation(animationSet);
            }
        } else if (v == btnSequence) {
            imgFly.setVisibility(View.VISIBLE);
            imgFly.startAnimation(animSequence);
        } else if (v == imgGhost) {
            imgGhost.startAnimation(animRotateReverse);
            relativeLayout.startAnimation(animRotate);
        } else if (v == btnFadeIn) {
            imgGhost.startAnimation(animFadeIn);
        } else if (v == btnFadeOut) {
            imgGhost.startAnimation(animFadeOut);
        } else if (v == btnRepeat) {
            imgGhost.startAnimation(animRepeat);
        } else if (v == btnZoomIn) {
            imgGhost.startAnimation(animZoomIn);
        } else if (v == btnZoomOut) {
            imgGhost.startAnimation(animZoomOut);
        } else if (v == btnMoveUp) {
            imgGhost.startAnimation(animMoveUp);
        } else if (v == btnMoveDown) {
            imgGhost.startAnimation(animMoveDown);
        } else if (v == btnMoveRight) {
            imgGhost.startAnimation(animMoveRight);
        } else if (v == btnMoveLeft) {
            imgGhost.startAnimation(animMoveLeft);
        } else if (v == btnRotate) {
            imgGhost.startAnimation(animRotate);
        } else if (v == btnSameTime) {
            imgGhost.startAnimation(animSameTime);
        }
    }

    public void loadAnimation() {
        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.anim_fadein);
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.anim_fadeout);
        animRepeat = AnimationUtils.loadAnimation(this, R.anim.anim_repeat);
        animZoomIn = AnimationUtils.loadAnimation(this, R.anim.anim_zoom_in);
        animZoomOut = AnimationUtils.loadAnimation(this, R.anim.anim_zoom_out);
        animMoveUp = AnimationUtils.loadAnimation(this, R.anim.anim_move_up);
        animMoveDown = AnimationUtils.loadAnimation(this, R.anim.anim_move_down);
        animMoveLeft = AnimationUtils.loadAnimation(this, R.anim.anim_move_left);
        animMoveRight = AnimationUtils.loadAnimation(this, R.anim.anim_move_right);
        animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        animRotateReverse = AnimationUtils.loadAnimation(this, R.anim.anim_rotate_reversed);
        animSequence = AnimationUtils.loadAnimation(this, R.anim.anim_sequence);
        animSameTime = AnimationUtils.loadAnimation(this, R.anim.anim_same_time);
    }

    private void addControls() {
        btnFadeIn = (Button) findViewById(R.id.button_fade_in);
        btnFadeOut = (Button) findViewById(R.id.button_fade_out);
        btnRepeat = (Button) findViewById(R.id.button_repeat);
        btnZoomIn = (Button) findViewById(R.id.button_zoom_in);
        btnZoomOut = (Button) findViewById(R.id.button_zoom_out);
        btnMoveUp = (Button) findViewById(R.id.button_move_up);
        btnMoveDown = (Button) findViewById(R.id.button_move_down);
        btnMoveLeft = (Button) findViewById(R.id.button_move_left);
        btnMoveRight = (Button) findViewById(R.id.button_move_right);
        btnSequence = (Button) findViewById(R.id.button_sequence);
        btnSameTime = (Button) findViewById(R.id.button_same_time);
        btnRotate = (Button) findViewById(R.id.button_rotate);

        imgBall = (ImageView) findViewById(R.id.image_view_ball);
        imgFly = (ImageView) findViewById(R.id.image_view_fly);
        imgGhost = (ImageView) findViewById(R.id.image_view_ghost);
        relativeLayout = ((RelativeLayout) findViewById(R.id.relative_layout_screen));
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

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
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
