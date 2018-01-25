package com.example.tmd.assets_sharepreferences;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChangeFont extends AppCompatActivity {

    /*
        - Share Preferences chỉ lưu được primary data và String
         + Nếu không đặt tên thì sẽ là tên Activity.xml
         + SharedPreferences preferences = getSharedPreferences("tên file", MODE_PRIVATE);
         + Get data: preferences.get...
         + Put data thì phải dùng Editor:
            SharedPreferences.Editor editor = preferences.edit();
            // editor.clear(); // xóa toàn bộ data của preferences
            editor.put...
            Phải dùng: editor.commit(); để xác nhận
         + Nên lưu trạng thái trước khi đóng phần mềm ở: onPause
         + Nên load trạng thái trước khi phần mềm chạy ở: onResume

        - Asset để chứa file sqplite, font, music,...
        - AssetManager assetManager = getAssets();
        - Lấy toàn bộ file trong "name_folder":
            assetManager.list("name_folder"); surround with try catch vì có thể folder không tồn tại
    */
    /*
         - Font:
            Typeface typeface = Typeface.createFromAsset(getAssets(), "font/" + fontName);
            txtName.setTypeface(typeface);
    */

    public static TextView txtTestFont;
    private List<String> mList;
    private FontAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<String> mFontName;

    /*
        2 cái này khác nhau:
        - FONT_SHARE_PREFERENCES khi ném vào getSharedPreferences(FONT_SHARE_PREFERENCES, MODE_PRIVATE);
            thì sẽ tạo 1 file FONT_SHARE_PREFERENCES.xml
        - FONT_NAME chỉ là 1 hằng bình thường như key để lấy dữ liệu từ FONT_SHARE_PREFERENCES.xml
    */
    public static String FONT_SHARE_PREFERENCES = "FONT_SHARE_PREFERENCES";
    public static String FONT_NAME = "FONT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_font);
        addControls();
    }

    private void addControls() {
        txtTestFont = (TextView) findViewById(R.id.text_view_test_font);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_font);
        mList = getFontName();
        mAdapter = new FontAdapter(this, mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        getPreviousFont();
    }

    public ArrayList<String> getFontName() {
        AssetManager assetManager = getAssets();
        String[] arrFontName = new String[0];
        try {
            arrFontName = assetManager.list("font");
        } catch (IOException e) {
            Log.e("ERROR_ASSESTS", e.toString());
        }
        ArrayList<String> mFontName = new ArrayList<String>();
        mFontName.addAll(Arrays.asList(arrFontName));
        return mFontName;
    }

    public void getPreviousFont() {
        SharedPreferences preferences = getSharedPreferences(FONT_SHARE_PREFERENCES, MODE_PRIVATE);
        String previousFontName = preferences.getString(FONT_NAME, "");// "" is default String if cant get anything
        if (!previousFontName.equals("")) {
            Toast.makeText(this, "SET PREVIOUS FONT", Toast.LENGTH_SHORT).show();
            Typeface typeface = Typeface.createFromAsset(getAssets(), previousFontName);
            txtTestFont.setTypeface(typeface);
        }
    }
}
