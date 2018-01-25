package com.example.tmd.displayhtmlintextview.KimDung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.tmd.displayhtmlintextview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.tmd.displayhtmlintextview.KimDung.ProcessDatabase.splitChapter;

public class showKimDung extends AppCompatActivity {

    private List<String> mList;
    private KimDungAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_split_kim_dung);
        addControls();
    }


    private void addControls() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_image);
        mList = new ArrayList<String>();
        addRow();

        mAdapter = new KimDungAdapter(this, mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void addRow() {
//        String[] content = getResources().getStringArray(R.array.THIEN_NHAI_TU_QUAN_BAT_KHA_VONG_2);
//        indent(content);
//        mList = Arrays.asList(content);
        mList = splitChapter();
    }

    public void indent(String[] content) {
        String numOfSpaceIndent = "  ";
        Character fisrtChar;
        String row;
        for (int i = 0; i < content.length; i++) {
//            row = content[i].toString();
//            if (row.length() > 0) {
//                fisrtChar = new Character(row.toLowerCase().charAt(0));
//                if (VietNamese_Chars.VIETNAMESE_ALL_CHAR.contains(fisrtChar)) {
            content[i] = numOfSpaceIndent + content[i];
//                }
//            }
        }
        System.gc();
    }
}
