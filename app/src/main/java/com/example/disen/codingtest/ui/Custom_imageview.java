package com.example.disen.codingtest.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by disen on 5/6/2018.
 */

public class Custom_imageview extends android.support.v7.widget.AppCompatImageView{
    public Custom_imageview(Context context) {
        super(context);
    }

    public Custom_imageview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Custom_imageview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int threeTwoheight = View.MeasureSpec.getSize(widthMeasureSpec) * 2 / 3;
        int threeTwoheightSpec = View.MeasureSpec.makeMeasureSpec(threeTwoheight, View.MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, threeTwoheightSpec);

    }
}
