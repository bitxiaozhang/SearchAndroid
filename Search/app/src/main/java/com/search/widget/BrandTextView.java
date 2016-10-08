package com.search.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class BrandTextView extends TextView {

    public BrandTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public BrandTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BrandTextView(Context context) {
        super(context);
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        if (style == Typeface.BOLD) {
            super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/LCD_TEXT.TTF"));
        } else {
            super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/LCD_TEXT.TTF"));
        }
    }
}
