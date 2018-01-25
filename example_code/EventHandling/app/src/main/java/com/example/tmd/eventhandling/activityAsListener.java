package com.example.tmd.eventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tmd.eventhandling.R;

public class activityAsListener extends AppCompatActivity implements View.OnLongClickListener {

    /*
        - Cả class là 1 listener
    */

    Button btnLongClick, btnShortClick, btnShowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_as_listener);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLongClick.setOnLongClickListener(this);//************************************************

        btnShortClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide(btnShortClick);
            }
        });
        btnShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(btnLongClick);
                show(btnShortClick);
            }
        });
    }

    private void show(View v) {
        v.setVisibility(View.VISIBLE);
    }

    private void hide(View v) {
        v.setVisibility(View.INVISIBLE);
    }

    private void addControls() {
        btnLongClick = (Button) findViewById(R.id.btnLongClick);
        btnShortClick = (Button) findViewById(R.id.btnShortClick);
        btnShowButton = (Button) findViewById(R.id.btnShowButton);
    }

    @Override
    public boolean onLongClick(View v) {
        if (v == btnLongClick) {
            hide(btnLongClick);
        }
        return false;
    }
}
