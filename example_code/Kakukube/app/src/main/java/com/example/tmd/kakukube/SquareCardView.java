package com.example.tmd.kakukube;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

/**
 * Created by tmd on 27/03/2017.
 */

public class SquareCardView extends CardView {

    public SquareCardView(Context context) {
        super(context);
    }

    public SquareCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
