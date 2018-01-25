package com.example.tmd.alertdialog_p;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tmd.alertdialog_p.R;

public class MainActivity extends AppCompatActivity {

    Button btnShowAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addControls() {
        btnShowAlertDialog = (Button) findViewById(R.id.btnShowAlertDialog);
    }

    private void addEvents() {
        btnShowAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(this);
        aBuilder.setTitle("This is title!!!");
        aBuilder.setIcon(R.mipmap.ic_launcher);
        aBuilder.setMessage("Are you sure want to exit?");
        aBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        aBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        aBuilder.create().show();
    }
}
