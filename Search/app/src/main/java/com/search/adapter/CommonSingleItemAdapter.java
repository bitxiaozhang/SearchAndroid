package com.search.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.search.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang shuailing on 2016/4/18.
 * email bitxiaozhang@163.com
 */
public class CommonSingleItemAdapter extends BaseAdapter {

    private List<String> datas;
    private Context mContext;

    public CommonSingleItemAdapter(List<String> datas, Context mContext) {
        this.datas = datas;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return datas == null ? 0:datas.size();
    }

    @Override
    public String getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.stick_item_layout, null);
        }
        ((TextView) view.findViewById(R.id.title)).setText(datas.get(i));
        return view;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
    }

    public List<String> getDatas() {
        return datas;
    }
}
