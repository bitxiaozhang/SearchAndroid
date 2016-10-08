package com.search.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.search.R;
import com.search.adapter.HistotySearchAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSearchHistoryList extends Fragment implements HistotySearchAdapter.OnRecycleItemClickListener {

    @Bind(R.id.search_tips)   TextView SearchTips;
    @Bind(R.id.history_search_list)   RecyclerView historySearchList;

    private HistotySearchAdapter historySeatchAdapter;

    public FragmentSearchHistoryList() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_search_history_list, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setLayout();
    }

    private void setLayout(){
        Context context = getActivity();
        historySearchList.setLayoutManager(new LinearLayoutManager(context));
        historySeatchAdapter = new HistotySearchAdapter(getHistorySearchData(),context);
        historySeatchAdapter.setOnItemClickListener(this);
        historySearchList.setAdapter(historySeatchAdapter);
    }

    public List<String> getHistorySearchData(){
        List<String> result = new ArrayList<>();
        result.add("sdasd");
        result.add("sdasd");
        result.add("sdasd");
        return result;
    }

    @Override
    public void onItemClick(String content) {
        //// TODO: 2016/4/8 搜索
    }
}
