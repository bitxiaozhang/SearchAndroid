package com.search.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.search.R;
import com.search.utils.DialogUtils;

public class WatchViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_view);
    }

    public void pickBirthDate(View view) {
        DialogUtils.selectDate(this, new DialogUtils.OnSelectedDelegate() {
            @Override
            public void onSelect(String result) {
                Toast.makeText(WatchViewActivity.this,result,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
