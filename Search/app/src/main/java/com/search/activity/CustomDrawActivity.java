package com.search.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.search.R;

public class CustomDrawActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int width;
    private galleryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_draw);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        Gallery gallery=(Gallery)findViewById(R.id.gallery);
        adapter=new galleryAdapter(this);
        gallery.setAdapter(adapter);
        gallery.setSpacing(5);
        gallery.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        adapter.setSelectItem((int)l);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public class galleryAdapter extends BaseAdapter {
        Context mContext;
        private int selectItem;
        private int drawable1[]=new int[] {R.drawable.gallery_test,R.drawable.gallery_test,R.drawable.gallery_test};
        public galleryAdapter(Context mContext){
            this.mContext=mContext;
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return Integer.MAX_VALUE;          //这里的目的是可以让图片循环浏览
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }
        public void setSelectItem(int selectItem) {

            if (this.selectItem != selectItem) {
                this.selectItem = selectItem;
                notifyDataSetChanged();
            }
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            ImageView imageView=new ImageView(mContext);
            imageView.setImageResource(drawable1[position%drawable1.length]);
//取余，让图片循环浏览

            if(selectItem==position){
//                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.my_scale_action);    //实现动画效果
                 Gallery.LayoutParams params = new Gallery.LayoutParams(width*3/5, 500);
                imageView.setLayoutParams(params);
//                imageView.startAnimation(animation);  //选中时，这是设置的比较大
            }
            else{
                imageView.setLayoutParams(new Gallery.LayoutParams(width/5,400));
//未选中
            }
            return imageView;
        }

    }
}
