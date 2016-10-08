package com.search;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import cn.smssdk.SMSSDK;

/**
 * Created by zhang shuailing on 2016/4/25.
 * email bitxiaozhang@163.com
 */
public class MainApplication extends Application {
    private static MainApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        LeakCanary.install(this);
        SMSSDK.initSDK(this, "12bcf9d6a2018", "26cdf01444c415d77503967ed11577b1");
    }

    public static MainApplication getInstance() {
        return instance;
    }
}
