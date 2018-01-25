package com.example.tmd.activity_p;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tmd.activity_p.R;

public class fullScreenWindow extends AppCompatActivity {

    Button btnReturn;
    String tab = "\t\t\t";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_window);

        addControls();
        addEvents();

        Toast.makeText(this, "fullScreenWindow: onCreate", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "fullScreenWindow: onCreate" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    private void addEvents() {
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appLifeCycle.stateLifeCycle += "<---return appLifeCycle\n";
                appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
                finish();
            }
        });
    }

    private void addControls() {
        btnReturn = (Button) findViewById(R.id.btnReturn);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "fullScreenWindow: onStart", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "fullScreenWindow: onStart" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "fullScreenWindow: onStop", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "fullScreenWindow: onStop" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "fullScreenWindow: onPause", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "fullScreenWindow: onPause" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "fullScreenWindow: onResume", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "fullScreenWindow: onResume" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "fullScreenWindow: onRestart", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "fullScreenWindow: onRestart" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "fullScreenWindow: onDestroy", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "fullScreenWindow: onDestroy" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }
}
