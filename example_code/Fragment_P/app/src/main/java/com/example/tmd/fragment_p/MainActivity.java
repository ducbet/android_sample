package com.example.tmd.fragment_p;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        QuestionFragment.OnSendResult {

    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_add_fragment).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add_fragment:
//                // Khởi tạo fragment transaction thông qua fragment maneger
//                FragmentManager fragmentManager = getSupportFragmentManager(); // TODO: 27/03/2017 2
//                FragmentTransaction transaction = fragmentManager.beginTransaction(); // TODO: 27/03/2017 3
//
//                // Khởi tạo fragment add vào framelayout
//                QuestionFragment fragment = new QuestionFragment();// TODO: 27/03/2017 4
//
//                // add: đè lên nhau
//                transaction.add(R.id.frame_content, fragment);// TODO: 27/03/2017 5
//
//                // replace: remove thằng cũ đi
////                transaction.replace(R.id.frame_content, fragment);
//
//                // commit transaction
//                transaction.commit();// TODO: 27/03/2017 6


                // có thể thay thế bằng:

                QuestionFragment fragment = QuestionFragment.newInstance(mCount);
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.frame_content, fragment)
                        .addToBackStack(null) // ấn back thì pop fragment trên cùng ra
                        .commit();
                mCount++;
                break;
            default:

                break;
        }
    }

    @Override
    public void onBackPressed() {
        // getBackStackEntryCount trả về số lượng fragment trong stack
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack(); // lấy fragment trên cùng ra
            mCount--;
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void sendResult(int result) {
        // TODO: 27/03/2017 3_3


        Toast.makeText(this, result+"", Toast.LENGTH_LONG).show();
    }
}
