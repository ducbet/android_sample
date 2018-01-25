package com.example.tmd.multi_language;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
        - Không được hardcode mà phải định nghĩa trong strings.xml
        - Tạo 1 file strings.xml (vi)
        - ID trong các ngôn ngữ phải giống nhau
        - Có thể open editer để sửa cho nhanh

    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
