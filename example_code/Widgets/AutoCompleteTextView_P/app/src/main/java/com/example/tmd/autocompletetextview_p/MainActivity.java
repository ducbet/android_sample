package com.example.tmd.autocompletetextview_p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.tmd.autocompletetextview_p.R;

public class MainActivity extends AppCompatActivity {

    /*
        - android:completionThreshold="1" : bắt đầu autoComplete từ ký tự thứ 1
        - Phần sổ xuống tương tự ListView, xử lý cũng thế
    */

    String[] listProvince;
    ArrayAdapter<String> adapterProvince;
    AutoCompleteTextView autoProvince;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
    }

    private void addControls() {
        autoProvince = (AutoCompleteTextView) findViewById(R.id.edtProvince);
        listProvince = getResources().getStringArray(R.array.tinhThanhVN);
        adapterProvince = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listProvince);
        autoProvince.setAdapter(adapterProvince);
    }
}
