package com.search.activity;

import android.app.Activity;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.search.R;
import com.search.adapter.CommonSingleItemAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

public class BGARefreshActivity extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener,
        BGARefreshLayout.BGARefreshLayoutDelegate {

    private BGARefreshLayout mRefreshLayout;
    private ListView mDataLv;

    private int mNewPageNumber;
    private int mMorePageNumber;

    private CommonSingleItemAdapter adapter;
    private Handler mHandler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bgarefresh);
        mRefreshLayout = (BGARefreshLayout) findViewById(R.id.rl_modulename_refresh);
        mDataLv = (ListView) findViewById(R.id.list_view);
        adapter = new CommonSingleItemAdapter(refreshData(new ArrayList<String>()),this);
        mDataLv.setAdapter(adapter);
        TextView textView = new TextView(this);
        textView.setLayoutParams(new AbsListView.LayoutParams(200,60));
        textView.setText("我就是Header");
        setListener();
    }

    protected void setListener() {
        mRefreshLayout.setDelegate(this);
        mRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(this, true));

        mDataLv.setOnItemClickListener(this);
        mDataLv.setOnItemLongClickListener(this);

    }

    private List<String> refreshData(List<String> datas){
        List<String> list = new ArrayList();
        for (int i =0; i<10 ;i++){
            list.add("数据"+i);
        }
        datas.addAll(list);
        return datas;
    }

    private List<String> loadMore(List<String> datas){
        List<String> list = new ArrayList();
        for (int i =0; i<10 ;i++){
            list.add("数据"+(10-i));
        }
        list.addAll(datas);
        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        return true;
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        mNewPageNumber++;
        if (mNewPageNumber > 4) {
            mRefreshLayout.endRefreshing();
            return;
        }else{
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapter.setDatas(refreshData(adapter.getDatas()));
                    adapter.notifyDataSetChanged();
                    mRefreshLayout.endRefreshing();
                }
            },1000);
        }
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        mMorePageNumber++;
        if (mMorePageNumber > 4) {
            mRefreshLayout.endLoadingMore();
            return false;
        }else{
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapter.setDatas(loadMore(adapter.getDatas()));
                    adapter.notifyDataSetChanged();
                    mRefreshLayout.endLoadingMore();
                }
            },1000);
        }
        return true;
    }
}
