package com.example.tmd.activity_p;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmd.activity_p.R;

import java.util.ArrayList;

import static android.util.TypedValue.COMPLEX_UNIT_SP;
import static android.view.Gravity.CENTER;
import static android.view.Gravity.LEFT;

public class appLifeCycle extends AppCompatActivity {

    /*
        - Cách tạo floating window: vào AndroidManifest,
                 thêm thuộc tính android:theme="@style/Base.Theme.AppCompat.Dialog...."

        - Bật activity: onCreate->onStart->onResume
        - Bị 1 activity khác che khuất toàn bộ: onPause->onStop
        - Sau khi bị che khuất toàn bộ rồi được bật lại: onRestart->onStart->onResume

        - Bị 1 activity khác che khuất 1 phần: onPause
        - Sau khi bị che khuất 1 phần rồi được focus lại: onResume

        => lưu trạng thái trong onPause, phục hồi trạng thái trong onResume
    */

    /*
        Intent:
        - Mở activity khác (làm ở appLifeCycle->fullScreenWindow)
        - Mở và truyền dữ liệu (làm ở appLifeCycle->floatingWindow)
            + Primitive Data Types (int , float, String):
                gửi: intent.putExtra(tên biến, giá trị cần truyền),
                nhận: intent.get...Extra(tên biến, giá trị mặc định nếu không nhận được giá trị đã gửi)
                    chú ý: intent.getStringExtra(tên biến);
            + Object: class phải implements Serializable
                nhận: intent.getSerializableExtra(tên biến);
            + Passing a Bundle: Bundle đóng gói các giá trị vào rồi gửi bằng intent.putExtra("BUNDLE", bundle);
                    nhận: intent.getBundleExtra("BUNDLE");
                            bundle.get...();

        - Mở, truyền dữ liệu, quan tâm dữ liệu trả về (làm ở appLifeCycle->bundle)
            + B1: Gửi dữ liệu: startActivityForResult(intent, mã(không trùng nhau));
            + B2: Lấy dữ liệu: như bình thường
            + B3: Gửi lại dữ liệu (sau khi thêm kết quả vào intent) (nên dùng lại intent):
                setResult(mã(không trùng nhau, kể cả với mã gửi), intent);
            + B4: Đóng activity nhận dữ liệu lại
                vì activity gửi dữ liệu chuyển sang Foreground lifetime thì mới nhận được results
            + B5: Nhận kết quả trong onActivityResult(); (chỉ khi activity nhận đang ở Foreground lifetime)
    */
    Button btnFullScreenWindow, btnFloatingWindow, btnBundle;
    public static TextView txtLifeCycle;
    public static String stateLifeCycle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_life_cycle);

        addControls();
        Toast.makeText(this, "appLifeCycle: onCreate", Toast.LENGTH_SHORT).show();
        stateLifeCycle += "appLifeCycle: onCreate" + "\n";
        txtLifeCycle.setText(stateLifeCycle);

        addEvents();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == 2){
            Bundle bundle = data.getBundleExtra("BUNDLE");
            int result = bundle.getInt("result");
            btnBundle.setTextSize(COMPLEX_UNIT_SP, 50);
            btnBundle.setGravity(LEFT|CENTER);
            btnBundle.setText(result+"!!!"); // để int là error
        }
    }

    private void addControls() {
        btnFloatingWindow = (Button) findViewById(R.id.btnFloatingWindow);
        btnFullScreenWindow = (Button) findViewById(R.id.btnFullScreenWindow);
        btnBundle = (Button) findViewById(R.id.btnBundle);
        txtLifeCycle = (TextView) findViewById(R.id.txtLifeCycle);
    }

    private void addEvents() {
        btnFullScreenWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appLifeCycle.this, fullScreenWindow.class);
                stateLifeCycle += "--->fullScreenWindow\n";
                startActivity(intent);

            }
        });
        btnFloatingWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appLifeCycle.this, floatingWindow.class);

                intent.putExtra("intentInt", 3);
                intent.putExtra("intentFloat", 234f);
                intent.putExtra("intentChar", 'c');
                intent.putExtra("intentString", "Hello World!!!");
                intent.putExtra("intentBoolean", true);

                SinhVien sv = new SinhVien(20145572, "Triệu Minh Đức");
                intent.putExtra("sv", sv);

                stateLifeCycle += "--->floatingWindow\n";
                startActivity(intent);
            }
        });
        btnBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appLifeCycle.this, bundle.class);
                addDataIntoBundle(intent);

                stateLifeCycle += "--->bundle\n";
                startActivityForResult(intent, 1);
            }
        });
    }

    private void addDataIntoBundle(Intent intent) {

        ArrayList<Integer> arrInt = new ArrayList<Integer>();
        arrInt.add(64);
        arrInt.add(18);
        arrInt.add(49);

        Bundle bundle = new Bundle();
        bundle.putDouble("bundleDouble", 123.9);
        bundle.putString("bundleString", "TMD");
        bundle.putIntegerArrayList("bunbleArrayList", arrInt);

        SinhVien sv = new SinhVien(20145572, "Triệu Minh Đức");
        bundle.putSerializable("sv", sv);

        bundle.putInt("a", 1);
        bundle.putInt("b", 1);

        intent.putExtra("BUNDLE", bundle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "appLifeCycle: onStart", Toast.LENGTH_SHORT).show();
        stateLifeCycle += "appLifeCycle: onStart" + "\n";
        txtLifeCycle.setText(stateLifeCycle);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "appLifeCycle: onStop", Toast.LENGTH_SHORT).show();
        stateLifeCycle += "appLifeCycle: onStop" + "\n";
        txtLifeCycle.setText(stateLifeCycle);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "appLifeCycle: onPause", Toast.LENGTH_SHORT).show();
        stateLifeCycle += "appLifeCycle: onPause" + "\n";
        txtLifeCycle.setText(stateLifeCycle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "appLifeCycle: onResume", Toast.LENGTH_SHORT).show();
        stateLifeCycle += "appLifeCycle: onResume" + "\n";
        txtLifeCycle.setText(stateLifeCycle);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "appLifeCycle: onRestart", Toast.LENGTH_SHORT).show();
        stateLifeCycle += "appLifeCycle: onRestart" + "\n";
        txtLifeCycle.setText(stateLifeCycle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "appLifeCycle: onDestroy", Toast.LENGTH_SHORT).show();
        stateLifeCycle += "appLifeCycle: onDestroy" + "\n";
        txtLifeCycle.setText(stateLifeCycle);
    }
}
