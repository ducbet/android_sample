package com.example.tmd.animation_objectanimator.Animation_P;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tmd.animation_objectanimator.R;

public class AnimationDrawableActivity extends AppCompatActivity implements View.OnClickListener {

    /*
        - Resource: search sprite sheet, sprite decomposer
        - B1: Tạo file xml gồm nhiều image trong drawable
        - B2: Tạo và gán giá trị cho AnimationDrawable
    */

    private Button btnStart, btnStop;
    private ImageView imgShow;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable);
        addControls();
        createDrawableAnimation();
        addEvents();
    }

    private void addEvents() {
        btnStop.setOnClickListener(this);
        btnStart.setOnClickListener(this);
    }

    private void createDrawableAnimation() {
        imgShow.setBackgroundResource(R.drawable.drawable_anim_minion);
        animationDrawable = (AnimationDrawable) imgShow.getBackground();
    }

    private void addControls() {
        btnStop = (Button) findViewById(R.id.button_stop);
        btnStart = (Button) findViewById(R.id.button_start);
        imgShow = (ImageView) findViewById(R.id.image_view_show);
    }

    @Override
    public void onClick(View v) {
        if (v == btnStart) {
            animationDrawable.start();
        } else if (v == btnStop) {
            animationDrawable.stop();
        }
    }
}
