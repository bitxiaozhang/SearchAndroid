package com.search.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.search.widget.CountDownTimerView;
import com.search.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TimerListViewActivity extends AppCompatActivity {

    @Bind(R.id.list_view)
    ListView listView;
    private TimerListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_list_view);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        List<String> list = new ArrayList<>();
        list.add("2016-05-23 12:22:30");
        list.add("2016-05-22 12:25:30");
        list.add("2016-05-24 12:12:20");
        list.add("2016-04-23 12:22:30");
        list.add("2016-04-23 12:40:23");
        list.add("2016-05-25 09:22:30");
        list.add("2016-07-23 12:22:30");
        list.add("2016-05-23 12:22:30");
        list.add("2016-05-22 12:25:30");
        list.add("2016-05-24 12:12:20");
        list.add("2016-04-23 12:22:30");
        list.add("2016-04-23 12:40:23");
        list.add("2016-05-25 09:22:30");
        list.add("2016-07-23 12:22:30");
        adapter = new TimerListAdapter(list,this);
        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }
    private class TimerListAdapter extends BaseAdapter{

        private List<String> datas ;
        private Context mContext;

        public TimerListAdapter(List<String> datas, Context mContext) {
            this.datas = datas;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return datas == null?0:datas.size();
        }

        @Override
        public Object getItem(int i) {
            return datas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null){
                view = LayoutInflater.from(mContext).inflate(R.layout.count_down_timer_layout,null);
                viewHolder = new ViewHolder();
                viewHolder.timerView = (CountDownTimerView) view.findViewById(R.id.timer_view);
                view.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) view.getTag();
            }

            viewHolder.timerView.setEndData(datas.get(i));
            return view;
        }

        protected class ViewHolder{
            CountDownTimerView timerView;
        }
    }
}
