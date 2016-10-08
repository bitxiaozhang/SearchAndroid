package com.search.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.search.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhang shuailing on 2016/4/8.
 * email bitxiaozhang@163.com
 */
public class HistotySearchAdapter extends RecyclerView.Adapter<HistotySearchAdapter.HistoryItemViewHolder>{

    private List<String> data;
    private Context context;
    private OnRecycleItemClickListener onItemClickListener;

    public HistotySearchAdapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public void setOnItemClickListener(OnRecycleItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public HistoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_search_history_item,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null){
                   String result = ((TextView)view.findViewById(R.id.content)).getText().toString().trim();
                    onItemClickListener.onItemClick(result);
                }
            }
        });
        return new HistoryItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryItemViewHolder holder, int position) {
        holder.contentTextView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null?0:data.size();
    }

     static class HistoryItemViewHolder extends RecyclerView.ViewHolder{

       @Bind(R.id.content) TextView contentTextView;
        public HistoryItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnRecycleItemClickListener{
        void onItemClick(String content);
    }
}
