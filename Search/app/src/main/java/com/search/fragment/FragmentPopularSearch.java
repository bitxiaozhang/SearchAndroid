package com.search.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.search.widget.PopularLabelItemView;
import com.search.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FragmentPopularSearch extends Fragment implements View.OnClickListener,PopularLabelItemView.OnLabelClickListener {

    private final static int popularMostNumber = 3;

    @Bind(R.id.change_datas_button) Button changeDataButton;
    @Bind(R.id.popular_labels) LinearLayout popularLabels;
    private List<String> mData = new ArrayList<>();
    public FragmentPopularSearch() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_popular_search, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setLayout();
        refresh();
    }

    private void setLayout(){
        changeDataButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.equals(changeDataButton)){
            refresh();
        }
    }

    public void refresh(){

        mData.clear();
        mData.add(String.valueOf(Math.random()));
        mData.add(String.valueOf(Math.random()));
        mData.add(String.valueOf(Math.random()));
        mData.add(String.valueOf(Math.random()));
        mData.add(String.valueOf(Math.random()));
        mData.add(String.valueOf(Math.random()));
        mData.add(String.valueOf(Math.random()));
        mData.add(String.valueOf(Math.random()));
        mData.add(String.valueOf(Math.random()));
        mData.add(String.valueOf(Math.random()));
        mData.add(String.valueOf(Math.random()));
        mData.add(String.valueOf(Math.random()));
        mData.add(String.valueOf(Math.random()));

        PopularLabelItemView itemView = null;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,60);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.setMargins(0, 10, 0, 10);
        popularLabels.removeAllViews();
        boolean isSolid = true;
        for (int i = 0;i<mData.size();i++){
            if (i>popularMostNumber-1){
                isSolid = false;
            }
            if (i%2 == 0){
                itemView = new PopularLabelItemView(getActivity());
                itemView.setLeftLabel(mData.get(i),isSolid);
                itemView.setOnItemClickListener(this);
                if (i == mData.size() -1){
                    popularLabels.addView(itemView,params);
                    break;
                }
            }else{
                itemView.setRightLabel(mData.get(i),isSolid);
                popularLabels.addView(itemView,params);
            }
        }
    }
    
    /*
     *Click the label of the populars
     */
    @Override
    public void onClick(String content) {
        //// TODO: 2016/4/8
    }
}
