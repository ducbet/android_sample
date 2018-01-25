package com.example.tmd.displayhtmlintextview;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showText();
    }

    private void showText() {
        mTextView = (TextView) findViewById(R.id.textView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Toast.makeText(this, "fromHtml with 2 params", Toast.LENGTH_SHORT).show();
            mTextView.setText(Html.fromHtml(textInHTML.content, Html.FROM_HTML_MODE_COMPACT));
        } else {
            Toast.makeText(this, "fromHtml with 1 param", Toast.LENGTH_SHORT).show();
            mTextView.setText(Html.fromHtml(textInHTML.content));
        }
    }
}
