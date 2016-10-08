package com.search.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.search.R;

/**
 * Created by zhang shuailing on 2016/4/8.
 * email bitxiaozhang@163.com
 */
public class PopularLabelItemView extends RelativeLayout implements View.OnClickListener {

    private TextView left;
    private TextView right;
    private View spacing;
    private OnLabelClickListener onItemClickListener;

    public PopularLabelItemView(Context context) {
        this(context, null);
    }

    public PopularLabelItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PopularLabelItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.fragment_popular_label_item, this);
        left = (TextView) findViewById(R.id.left_label);
        right = (TextView) findViewById(R.id.right_label);
        spacing = findViewById(R.id.spacing);
        left.setVisibility(GONE);
        right.setVisibility(GONE);
    }

    public void setLeftLabel(String leftString,boolean isSolid){
        left.setVisibility(VISIBLE);
        left.setText(leftString);
        Resources res = getContext().getResources();
        if (isSolid){
            left.setTextColor(Color.WHITE);
            left.setBackground(res.getDrawable(R.drawable.shape_search_popular_button_label_solid));
        }else{
            left.setTextColor(res.getColor(R.color.colorPopularSearchButton));
            left.setBackground(res.getDrawable(R.drawable.shape_search_popular_button_label_hollow));
        }

        left.setOnClickListener(this);
    }

    public void setRightLabel(String rightString,boolean isSolid){
        right.setVisibility(VISIBLE);
        right.setText(rightString);
        spacing.setVisibility(VISIBLE);
        Resources res = getResources();
        if (isSolid){
            right.setTextColor(Color.WHITE);
            right.setBackground(res.getDrawable(R.drawable.shape_search_popular_button_label_solid));
        }else{
            right.setTextColor(res.getColor(R.color.colorPopularSearchButton));
            right.setBackground(res.getDrawable(R.drawable.shape_search_popular_button_label_hollow));
        }
        right.setOnClickListener(this);
    }

    public void setOnItemClickListener(OnLabelClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onClick(View view) {
        String content = ((TextView)view).getText().toString().trim();
        if (onItemClickListener != null){
            onItemClickListener.onClick(content);
        }
    }

    public interface  OnLabelClickListener{
        void onClick(String content);
    }
}
