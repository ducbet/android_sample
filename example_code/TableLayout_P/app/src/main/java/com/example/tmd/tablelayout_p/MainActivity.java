package com.example.tmd.tablelayout_p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.tmd.tablelayout_p.R;

public class MainActivity extends AppCompatActivity {
    /*
        - Tạo 1 activity mới thì vào chỉnh sang LinearLayout luôn, sau rồi kéo TableLayout vào sau.
        1 TableLayout có nhiều TableRow. Hệ thống sẽ lấy Row có nhiều Cell nhất làm số Cell của Table
            + android:layout_column="2" : xác định Cell cho View
            + android:layout_span="2" :     gộp 2 Cell liền nhau lại
            + android:stretchColumns="*" : Cell căng ra để fit parent (chỉ khi Cell chưa kín Row, còn nếu quá thì không được)
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title bar,..//phai de truoc setContentView(R.layout.activity_animation);
        removeTittleBar();
        setContentView(R.layout.activity_main);
    }

    public void removeTittleBar() {
        //remove title bar,..//phai de truoc setContentView(R.layout.activity_animation);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //---
        getSupportActionBar().hide();
    }
}
