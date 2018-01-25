package tmd.customview;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by trieu_000 on 7/10/2017.
 */

public class CustomProgressBar extends android.support.v7.widget.AppCompatImageView {

    private int barHeight;
    private int circleRadius;
    private int spaceAfterBar;
    private int circleTextSize;
    private int maxValueTextSize;
    private int labelTextSize;
    private int labelTextColor;
    private int currentValueTextColor;
    private int circleTextColor;
    private int baseColor;
    private int fillColor;
    private String labelText;


    public CustomProgressBar(Context context) {
        super(context);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (widthMeasureSpec < heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
