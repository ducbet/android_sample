package com.example.tmd.activity_p;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmd.activity_p.R;

public class floatingWindow extends AppCompatActivity {

    TextView txtShowIntent;
    String tab = "\t\t\t";
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_window);

        Toast.makeText(this, "floatingWindow: onCreate", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "floatingWindow: onCreate" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
        addControls();
        addEvents();
        showIntent();

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

    private void showIntent() {
        Intent intent = getIntent();
        int intentInt = intent.getIntExtra("intentIntttttttttttttttttt", 0);
        float intentFloat = intent.getFloatExtra("intentFloat", -1f);
        char intentChar = intent.getCharExtra("intentChar", 'a');
        String intentString = intent.getStringExtra("intentStringggggggggggggggggggg");
        boolean intentBoolean = intent.getBooleanExtra("intentBoolean", false);

        SinhVien sv = (SinhVien) intent.getSerializableExtra("sv");

        txtShowIntent.setText(
                "intentInt: " + intentInt + "\n" +
                        "intentFloat: " + intentFloat + "\n" +
                        "intentChar: " + intentChar + "\n" +
                        "intentString: " + intentString + "\n" +
                        "intentBoolean: " + intentBoolean + "\n" +
                        "sv: " + sv.toString()
        );
    }

    private void addControls() {
        txtShowIntent = (TextView) findViewById(R.id.txtShowIntent);
        btnReturn = (Button) findViewById(R.id.btnReturn);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "floatingWindow: onStart", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "floatingWindow: onStart" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "floatingWindow: onStop", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "floatingWindow: onStop" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "floatingWindow: onPause", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "floatingWindow: onPause" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "floatingWindow: onResume", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "floatingWindow: onResume" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "floatingWindow: onRestart", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "floatingWindow: onRestart" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "floatingWindow: onDestroy", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "floatingWindow: onDestroy" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }
}
