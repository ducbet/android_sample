package com.example.tmd.textview_edittext_button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tmd.textview_edittext_button.R;

public class MainActivity extends AppCompatActivity {
    /*
        - android:background="" : thay đổi màu background
        - android:textColorHighlight="" : thay đổi màu khi bôi đen
            + @android:color/ : tự chọn màu
            + @color/colorPrimary : màu project (trùng vs màu thanh ghi tên project trên cùng)
        - android:textSize="30dp" : thay đổi cỡ chữ
        - EditText
            + android:hint="Nhập String vào đây" : hiện dòng chữ mờ, biến mất khi xâu khác rỗng

        - Button
            + android:textAllCaps="false" : tắt chế độ tự động upperCase text

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
