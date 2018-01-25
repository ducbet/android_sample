package com.example.tmd.eventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tmd.eventhandling.R;

public class anonymousListener extends AppCompatActivity {

    /*
        - Có thể dùng khi View chưa xuất hiện vì được viết trong file .java chứ k phải .xml
    */

    EditText edtA, edtB;
    Button btnSubShortClick, btnSubLongClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anonymous_listener);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSubShortClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubtraction();
            }
        });
        btnSubLongClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                handleSubtraction();
                return false;
            }
        });
    }

    private void handleSubtraction() {
        String strA = edtA.getText().toString();
        String strB = edtB.getText().toString();
        if (strA.equals("")) {
            edtA.requestFocus();
            return;
        } else if (strB.equals("")) {
            edtB.requestFocus();
            return;
        }
        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        int c = a - b;
        Toast.makeText(this, a + " - " + b + " = " + c, Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        btnSubShortClick = (Button) findViewById(R.id.btnSubShortClick);
        btnSubLongClick = (Button) findViewById(R.id.btnSubLongClick);
    }
}
