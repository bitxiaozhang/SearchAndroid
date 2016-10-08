package com.search;

import android.content.Context;

/**
 * Created by zhang shuailing on 2016/4/25.
 * email bitxiaozhang@163.com
 */
public class LeakSingleInstanceTest {

    private static Context context;
    private static LeakSingleInstanceTest ourInstance ;

    public static LeakSingleInstanceTest getInstance(Context context) {
        if (ourInstance == null){
            ourInstance = new LeakSingleInstanceTest(context);
        }
        return ourInstance;
    }

    private LeakSingleInstanceTest(Context context) {
        this.context = context;
    }
}
