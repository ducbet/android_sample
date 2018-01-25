package com.example.tmd.activity_p.implicitIntent;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tmd.activity_p.R;

public class call_sms extends AppCompatActivity {

    /*
        - Phải cấp quyền trong manifests
            + READ_SMS: Cho phép phần mềm đọc SMS
            + SEND_SMS: Cho phép phần mềm gửi SMS
            + CALL_PHONE: Cho phép phần mềm thực hiện gọi điện thoại
        - Tùy hành động mà phải setData(uri)->request permission

    */

    Button btnCall, btnSendSMS, btnDial;
    EditText edtPhoneNumber, edtSMSContent;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_sms);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });
        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial(); // quay số
            }
        });
    }

    private void sendSMS() {
        // lấy mặc định SmsManager
        final SmsManager sms = SmsManager.getDefault();
        Intent intent = new Intent(Intent.ACTION_SEND);
//        Intent intent = new Intent("ACTION_MSG_SENT"); // 1 trong 2 cách tạo Intent
        // Khai báo PendingIntent để kiểm tra kết quả trả về (gửi thành công hay không)
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String message = "Send OK";
                if (result != Activity.RESULT_OK) {
                    message = "Send Failed";
                }
                Toast.makeText(call_sms.this, message, Toast.LENGTH_LONG).show();
            }
        }, new IntentFilter(Intent.ACTION_SEND));
        // Gọi hàm gửi tin nhắn
        sms.sendTextMessage(edtPhoneNumber.getText().toString(), null,
                edtSMSContent.getText().toString(),
                pendingIntent, null);
    }

    private void dial() {
        Intent intent = new Intent(Intent.ACTION_DIAL);

        // chỉ startActivity khi có ít nhất 1 ứng dụng có thể nhận được intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Không có ứng dụng phù hợp", Toast.LENGTH_LONG).show();
        }

    }

    private void call() {
        uri = Uri.parse("tel:" + edtPhoneNumber.getText().toString().trim()); // "tel:" là mặc định
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(uri);
        // tại sao không request permission mà vẫn gọi được???
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Không có ứng dụng phù hợp", Toast.LENGTH_LONG).show();
        }
    }

    private void addControls() {
        btnCall = (Button) findViewById(R.id.btnCall);
        btnSendSMS = (Button) findViewById(R.id.btnSendSMS);
        btnDial = (Button) findViewById(R.id.btnDial);
        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber);
        edtSMSContent = (EditText) findViewById(R.id.edtSMSContent);
    }
}
