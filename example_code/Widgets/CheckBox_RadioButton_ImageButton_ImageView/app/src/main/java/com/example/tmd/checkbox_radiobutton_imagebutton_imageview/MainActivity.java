package com.example.tmd.checkbox_radiobutton_imagebutton_imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
        - CheckBox: có thể chọn nhiều lựa chọn.
        - RadioButton: chỉ có thể chọn 1 lựa chọn.
            + Phải gom các RadioButton vào RadioGroup
            + Có thể để các lựa chọn theo chiều ngang hoặc dọc (GroupRadioButton -> android:orientation)
            + groupRadioButtonName.clearCheck(); xóa hết lựa chọn của các RadioButton trong Group
            + groupRadioButtonName.getCheckedRadioButtonId(); trả về RadioButton được chọn,
                                                                -1 nếu không có gì được chọn
            + groupRadioButtonName.addView(); add RadioButton vào RadioGroup
            + radName.setOnCheckedChangeListener: bắt sự kiện khi trạng thái checked/unchecked
                                                            của RadioButton hoặc CheckBox bị thay đổi
            + getText().toString(); có thể dùng với RadioButton
        - ImageButton: Button có background là Image (bản chất vẫn là Button)
        - ImageView:
            + android:scaleType="centerCrop": điều chỉnh tỷ lệ co dãn của ảnh
    */

    EditText edtName;
    RadioGroup gRadGender, gRadSchool;
    RadioButton radHUST, radNUCE, radHANU, radVNU, radNEU, radMale, radFemale;
    CheckBox chkIT, chkSoftSkills, chkForeignLanguage;
    ImageView imgLogoShool;
    ImageButton imbSendCV, imbClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        schoolEvent();
        sendEvent();
        clearEvent();
    }

    private void clearEvent() {
        imbClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtName.setText("");
                gRadGender.clearCheck();
                gRadSchool.clearCheck();
                chkIT.setChecked(false);
                chkSoftSkills.setChecked(false);
                chkForeignLanguage.setChecked(false);
                imgLogoShool.setImageResource(0);
            }
        });
    }

    private void sendEvent() {
        imbSendCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cv = "Name: ";
                cv += edtName.getText().toString() + "\n";

                cv += "Gender: ";
                int radioButtonChecked = 0;
                radioButtonChecked = gRadGender.getCheckedRadioButtonId();
                if (radioButtonChecked != -1) {
                    cv += ((RadioButton) findViewById(radioButtonChecked)).getText().toString();
                }
                cv += "\n";
                cv += "School: ";
                radioButtonChecked = gRadSchool.getCheckedRadioButtonId();
                if (radioButtonChecked != -1) {
                    cv += ((RadioButton) findViewById(radioButtonChecked)).getText().toString();
                }
                cv += "\n";

                cv += "Skill: \n\t";
                if (chkIT.isChecked()) {
                    cv += chkIT.getText().toString() + "\n\t";
                }
                if (chkSoftSkills.isChecked()) {
                    cv += chkSoftSkills.getText().toString() + "\n\t";
                }
                if (chkForeignLanguage.isChecked()) {
                    cv += chkForeignLanguage.getText().toString() + "\n\t";
                }
                Toast.makeText(MainActivity.this, cv, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void schoolEvent() {
        radHUST.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    changeImage(R.drawable.hust);
                }
            }
        });
        radVNU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    changeImage(R.drawable.vnu);
                }
            }
        });
        radNUCE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    changeImage(R.drawable.nuce);
                }
            }
        });
        radHANU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    changeImage(R.drawable.hanu);
                }
            }
        });
        radNEU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    changeImage(R.drawable.neu);
                }
            }
        });
    }

    private void changeImage(int image) {
        imgLogoShool.setImageResource(image);
    }

    private void addControls() {
        edtName = (EditText) findViewById(R.id.edtName);
        gRadGender = (RadioGroup) findViewById(R.id.gRadGender);
        gRadSchool = (RadioGroup) findViewById(R.id.gRadSchool);
        radHUST = (RadioButton) findViewById(R.id.radHUST);
        radNUCE = (RadioButton) findViewById(R.id.radNUCE);
        radHANU = (RadioButton) findViewById(R.id.radHANU);
        radVNU = (RadioButton) findViewById(R.id.radVNU);
        radNEU = (RadioButton) findViewById(R.id.radNEU);
        radFemale = (RadioButton) findViewById(R.id.radFemale);
        radMale = (RadioButton) findViewById(R.id.radMale);
        chkIT = (CheckBox) findViewById(R.id.chkIT);
        chkSoftSkills = (CheckBox) findViewById(R.id.chkSoftSkills);
        chkForeignLanguage = (CheckBox) findViewById(R.id.chkForeignLanguage);
        imgLogoShool = (ImageView) findViewById(R.id.imgLogoShool);
        imbSendCV = (ImageButton) findViewById(R.id.imbSendCV);
        imbClear = (ImageButton) findViewById(R.id.imbClear);
    }
}
