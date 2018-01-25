package com.example.tmd.eventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tmd.eventhandling.R;

public class onClickXML extends AppCompatActivity {
    /*
        - onClick: phải có View trước, viết  onClick vào file .xml trước thì mới được
                (android:onClick="addHandle")
    */

    EditText edtA, edtB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_xml);

        addControls();
    }

    private void addControls() {
        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
    }

    public void addHandle(View v) { //android:onClick="addHandle"
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
        int c = a + b;
        Toast.makeText(this, a + " + " + b + " = " + c, Toast.LENGTH_LONG).show();
    }
}
