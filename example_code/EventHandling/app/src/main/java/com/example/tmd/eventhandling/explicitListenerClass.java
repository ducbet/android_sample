package com.example.tmd.eventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tmd.eventhandling.R;

public class explicitListenerClass extends AppCompatActivity {

    /*
        - explicit : rõ ràng, tường minh. Khi dự án lớn, ta nên xây dựng 1 lớp có tên dễ hiểu, tường minh
        - Dùng để tự tạo ra 1 class khác dạng listener
        - Nên khai báo inner class để sử dụng các View của this.class
    */

    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_listener_class);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnExit.setOnClickListener(new myEvents());
    }

    public class myEvents implements View.OnLongClickListener, View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v == btnExit) finish();
        }

        @Override
        public boolean onLongClick(View v) {
            if (v == btnExit) finish();
            return false;
        }
    }

    private void addControls() {
        btnExit = (Button) findViewById(R.id.btnExit);
    }
}
