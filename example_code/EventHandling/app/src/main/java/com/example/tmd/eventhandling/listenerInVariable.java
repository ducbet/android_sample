package com.example.tmd.eventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tmd.eventhandling.R;

public class listenerInVariable extends AppCompatActivity {

    /*
        - Dùng khi cần chia sẻ (2 hay nhiều View dùng chung 1 listener)
    */

    EditText edtA, edtB;
    Button btnMul, btnDiv;

    View.OnClickListener eventsHandling = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener_in_variable);

        addControls();
        addEvents();
    }

    private void addEvents() {
        eventsHandling = new View.OnClickListener() {// không được đặt ở đầu vì View chưa được gán id
            @Override
            public void onClick(View v) {
                if (v == btnMul) {
                    handleMultiplication();
                } else if (v.getId() == R.id.btnDiv) {//cách viết khác
                    handeDivision();
                }
            }
        };
        btnMul.setOnClickListener(eventsHandling);//đặt sau eventsHandling = new View.OnClickListener()
        btnDiv.setOnClickListener(eventsHandling);
    }

    private void handeDivision() {
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
        double c = ((double) a) / b;
        Toast.makeText(this, a + " / " + b + " = " + c, Toast.LENGTH_LONG).show();
    }

    private void handleMultiplication() {
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
        int c = a * b;
        Toast.makeText(this, a + " * " + b + " = " + c, Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        btnMul = (Button) findViewById(R.id.btnMuti);
        btnDiv = (Button) findViewById(R.id.btnDiv);
    }
}
