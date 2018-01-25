package com.example.tmd.spinner_p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tmd.spinner_p.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    /*
        - Giống ListView, dùng cho TH không quá dài
        - mAdapterName = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mArrDay);
        - mAdapterName.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Không có thì cũng chả khác gì???

        - mSpinnerName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {});
            ＋nên để 1 biến position và lưu lại vị trí clicked
    */

    private String[] mArrDay = new String[31];
    private ArrayList<String> mArrMonth;
    private ArrayList<String> mArrYear;
    private ArrayAdapter<String> mDayhAdapter;
    private ArrayAdapter<String> mMonthAdapter;
    private ArrayAdapter<String> mYearAdapter;
    private Spinner mSpinnerDay, mSpinnerMonth, mSpinnerYear;

    private Button mBtnSave;
    private EditText mEdtName;

    private int mPositonDay, mPositonMonth, mPositonYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        setDataSpinner();

        mDayhAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mArrDay);
//        mDayhAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMonthAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mArrMonth);
//        mMonthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mYearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mArrYear);
//        mYearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        mSpinnerDay.setAdapter(mDayhAdapter);
        mSpinnerDay.setSelection(14); // Đặt ở ngày 15
        mSpinnerMonth.setAdapter(mMonthAdapter);
        mSpinnerYear.setAdapter(mYearAdapter);
        mSpinnerYear.setSelection(70); // Đặt ở năm 1970

        addEvents();

    }

    private void addEvents() {
        mSpinnerDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(spinner.this, mArrDay[position], Toast.LENGTH_SHORT).show();
                mPositonDay = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSpinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(spinner.this, mArrMonth.get(position), Toast.LENGTH_SHORT).show();
                mPositonMonth = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSpinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(spinner.this, mArrYear.get(position), Toast.LENGTH_SHORT).show();
                mPositonYear = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String show = mEdtName.getText() + " sinh " +
                        mArrDay[mPositonDay] + " " +
                        mArrMonth.get(mPositonMonth) + " " +
                        mArrYear.get(mPositonYear);
                Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setDataSpinner() {
        for (int i = 0; i < 31; i++) {
            mArrDay[i] = "Ngày " + (i + 1);
        }

        mArrMonth = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.month)));

        mArrYear = new ArrayList<String>();
        for (int i = 1900; i < 2017; i++) {
            mArrYear.add("Năm " + i);
        }
    }

    private void addControls() {
        mSpinnerDay = (Spinner) findViewById(R.id.spinnner_day);
        mSpinnerMonth = (Spinner) findViewById(R.id.spinnner_month);
        mSpinnerYear = (Spinner) findViewById(R.id.spinnner_year);
        mBtnSave = (Button) findViewById(R.id.button_save);
        mEdtName = (EditText) findViewById(R.id.edit_text_name);
    }

}
