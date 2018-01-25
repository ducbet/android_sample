package com.example.tmd.activity_p;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmd.activity_p.R;

import java.util.ArrayList;

public class bundle extends AppCompatActivity {
    /*
        - Nhận Bundle từ appLifeCycle
    */

    TextView txtShowBundle;
    String tab = "\t\t\t";
    Button btnReturn;
    int a, b, result;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle);

        addControls();
        addEvents();

        showBundle();

        Toast.makeText(this, "bundle: onCreate", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "bundle: onCreate" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }


    private void addEvents() {
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appLifeCycle.stateLifeCycle += "<---return appLifeCycle\n";
                appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);


                result = a + b;
                bundle.putInt("result", result);

                intent.putExtra("BUNDLE", bundle); // phải put lại bundle vào intent
                setResult(2, intent);
                finish();
            }
        });
    }

    private void showBundle() {
        intent = getIntent();
        bundle = intent.getBundleExtra("BUNDLE");
        SinhVien sv = (SinhVien) bundle.getSerializable("sv");
        ArrayList<Integer> arrayInt = bundle.getIntegerArrayList("bunbleArrayList");
        a = bundle.getInt("a");
        b = bundle.getInt("b");

        txtShowBundle.setText(
                "bundleDouble: " + bundle.getDouble("bundleDouble") + "\n" +
                        "bundleString: " + bundle.getString("bundleString") + "\n" +
                        "Sinh viên: " + sv + "\n" +
                        "arrayInt: " + arrayInt.get(0) + ", " + arrayInt.get(1) + ", " + arrayInt.get(2) + "\n\n\n" +
                        "a: " + a + "\n" +
                        "b: " + b + "\n"
        );
    }

    private void addControls() {
        txtShowBundle = (TextView) findViewById(R.id.txtShowBundle);
        btnReturn = (Button) findViewById(R.id.btnReturn);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "bundle: onStart", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "bundle: onStart" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "bundle: onStop", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "bundle: onStop" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "bundle: onDestroy", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "bundle: onDestroy" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "bundle: onPause", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "bundle: onPause" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "bundle: onResume", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "bundle: onResume" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "bundle: onRestart", Toast.LENGTH_SHORT).show();
        appLifeCycle.stateLifeCycle += tab + "bundle: onRestart" + "\n";
        appLifeCycle.txtLifeCycle.setText(appLifeCycle.stateLifeCycle);
    }
}
