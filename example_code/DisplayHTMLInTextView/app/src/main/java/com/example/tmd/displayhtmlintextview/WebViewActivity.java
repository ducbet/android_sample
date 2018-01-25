package com.example.tmd.displayhtmlintextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        showText();
    }

    private void showText() {
        mWebView = (WebView) findViewById(R.id.web_view);
        mWebView.loadData(textInHTML.content, "text/html; charset=UTF-8", null);
    }
}
