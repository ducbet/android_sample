package com.example.tmd.datepickerdialog_timepickerdialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    /*
        - DatePickerDialog datePicker = new DatePickerDialog(...);
        - Phải tạo 1 listener callback để nhận biết việc người dùng lựa chọn thời gian
        - datePicker.setTitle("...");
        - datePicker.show();
        - Hiện ngày hiện tại ở textView, cập nhật lại thời gian mà người dùng chọn,
            nếu bật lên lần nữa thì lấy luôn thời gian này mà không bị về thời gian cố định
    */

    private Button mBtnDate, mBtnTime, mBtnSave;
    private EditText mEdtJob, mEdtContent;
    private TextView mTxtDate, mTxtHour;

    private JobWeek mNewJob;
    private ArrayList<JobWeek> mArrJob;
    private ArrayAdapter<JobWeek> mJobAdapter;
    private ListView mLvJob;

    private Calendar mCalendar = Calendar.getInstance();
    public static SimpleDateFormat sdfTime, sdfDate, sdfHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        setTextView();
        setDataListView();

        addEvents();
    }

    private void setTextView() {
        // Hiện ngày hiện tại ở textView, về sau sẽ dùng ngày giờ này để khởi tạo Dialog
        // (Khi bật dialog lần nữa thì không bị về thời gian cố định)
        sdfDate = new SimpleDateFormat("dd/MM/yyyy");
        mTxtDate.setText(sdfDate.format(mCalendar.getTime()).toString());
        sdfHour = new SimpleDateFormat("HH:mm");
        mTxtHour.setText(sdfHour.format(mCalendar.getTime()).toString());
        sdfTime = new SimpleDateFormat("HH:mm dd/MM/yyyy");
    }

    private void addEvents() {
        mLvJob.setOnItemClickListener(new ListViewEvent());
        mLvJob.setOnItemLongClickListener(new ListViewEvent());
        mBtnTime.setOnClickListener(new ButtonEvent());
        mBtnDate.setOnClickListener(new ButtonEvent());
        mBtnSave.setOnClickListener(new ButtonEvent());
    }

    private void setDataListView() {
        mArrJob = new ArrayList<JobWeek>();
        mJobAdapter = new ArrayAdapter<JobWeek>(this, android.R.layout.simple_list_item_1, mArrJob);
        mLvJob.setAdapter(mJobAdapter);
    }

    private void addControls() {
        mBtnDate = (Button) findViewById(R.id.button_date);
        mBtnSave = (Button) findViewById(R.id.button_save);
        mBtnTime = (Button) findViewById(R.id.button_time);

        mEdtContent = (EditText) findViewById(R.id.edit_text_content);
        mEdtJob = (EditText) findViewById(R.id.edit_text_job);
        mTxtDate = (TextView) findViewById(R.id.text_view_ngay_hoan_thanh);
        mTxtHour = (TextView) findViewById(R.id.text_view_gio_hoan_thanh);

        mLvJob = (ListView) findViewById(R.id.list_view_job);
    }

    private class ButtonEvent implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == mBtnDate) {
                showDatePickerDialog();
            } else if (v == mBtnTime) {
                showTimePickerDialog();
            } else if (v == mBtnSave) {
                mNewJob = new JobWeek(mEdtJob.getText().toString(), mEdtContent.getText().toString(), mCalendar.getTime());
                mArrJob.add(mNewJob);
                Collections.sort(mArrJob);
                mJobAdapter.notifyDataSetChanged();
            }
        }

    }

    private void showTimePickerDialog() {
        final TimePickerDialog.OnTimeSetListener callBack = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mTxtHour.setText(hourOfDay + ":" + minute);
                mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                mCalendar.set(Calendar.MINUTE, minute);
            }
        };
        String[] time = mTxtHour.getText().toString().split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        TimePickerDialog timePicker = new TimePickerDialog(this, callBack, hour, minute, true);
        timePicker.setTitle("Chọn giờ hoàn thành");
        timePicker.show();
    }

    private void showDatePickerDialog() {
        DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Mỗi lần thay đổi thì hàm này được gọi
                // Cập nhật lại textView để người dùng nhìn
                mTxtDate.setText(dayOfMonth + "/" + month + "/" + year);
                mCalendar.set(year, month, dayOfMonth);
            }
        };

        // Vì cần truyền vào hàm khởi tạo DatePickerDialog ngày tháng năm.
        // Nên lấy ngày tháng năm hiện tại để truyền vào (đang lưu ở texView)
        String[] date = mTxtDate.getText().toString().split("/");

        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);

        DatePickerDialog datePicker = new DatePickerDialog(this, callBack, year, month, day);
        datePicker.setTitle("Chọn ngày hoàn thành");
        datePicker.show();

    }

    private class ListViewEvent implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, mArrJob.get(position).getContent(), Toast.LENGTH_LONG).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            mArrJob.remove(position);
            mJobAdapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Đã xóa công việc : " + mArrJob.get(position).getName(), Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
