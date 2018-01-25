package com.example.tmd.test_del;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import static android.widget.RelativeLayout.ALIGN_PARENT_LEFT;
import static android.widget.RelativeLayout.ALIGN_PARENT_START;
import static android.widget.RelativeLayout.ALIGN_PARENT_TOP;

/**
 * Created by tmd on 23/08/2017.
 */
public class ImageAwesomeTable extends android.support.v7.widget.AppCompatImageView {
    private static final String TAG = "ImageAwesomeTable";
    private AwesomeTable mTable;
    private RelativeLayout.LayoutParams mParams;

    public ImageAwesomeTable(Context context, AwesomeTable table) {
        super(context);
        mTable = table;
        initTable();
    }

    private void initTable() {
        mParams = new RelativeLayout.LayoutParams(mTable.getWidth(), mTable.getHeight());
        Log.d(TAG, "initTable: "+ mTable.getWidth() + "___" + mTable.getHeight());
        mParams.addRule(ALIGN_PARENT_LEFT);
        mParams.addRule(ALIGN_PARENT_START);
        mParams.addRule(ALIGN_PARENT_TOP);
        mParams.leftMargin = mTable.getY();
        mParams.topMargin = mTable.getX();
        setLayoutParams(mParams);
        setBackgroundResource(mTable.getImage());
        Log.e("MY_TAG", "initTable: ");
    }

}
