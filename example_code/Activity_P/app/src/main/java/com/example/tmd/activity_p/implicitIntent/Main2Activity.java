package com.example.tmd.activity_p.implicitIntent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.tmd.activity_p.R;

public class Main2Activity extends AppCompatActivity {

    /*
        - Sử dụng 1 ứng dụng nào đấy có sẵn
        - Có thể phải cấp quyền trong manifests
    */

    Button btnPhone, btnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_intent);

        addControls();
    }

    private void addControls() {
        btnPhone = (Button) findViewById(R.id.btnPhone);
        btnCamera = (Button) findViewById(R.id.btnCamera);
    }

    public void openPhone(View view) {
        Intent intent = new Intent(this, call_sms.class);
        startActivity(intent);
    }

    public void openCamera(View view) {
        Intent intent = new Intent(this, camera.class);
        startActivity(intent);
    }
}
