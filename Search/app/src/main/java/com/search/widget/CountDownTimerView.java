package com.search.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhang shuailing on 2016/4/13.
 * email bitxiaozhang@163.com
 */
public class CountDownTimerView extends TextView {

    private Timer mTimer;
    private String mText;

    private long mTime;
    private int day;
    private int mHour;
    private int mMinute;
    private int mSecond;

    public CountDownTimerView(Context context) {
        this(context, null);
    }

    public CountDownTimerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownTimerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (mTime == 0){
                    mText = "";
                }else{
                    mTime--;
                    mText = getDisplayString(mTime);
                }
                postInvalidate();
            }
        }, 0, 1000);
    }


    /*
     *@param data yyyy-MM-dd HH:mm:ss
     */
    public void setEndData(String data){
        mTime = getTimeInterval(data);
        mText = getDisplayString(mTime);
    }

    /**
     * 获取两个日期的时间差
     */
    public static long getTimeInterval(String data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = 0;
        try {
            Date currentTime = new Date();// 获取现在的时间
            Date beginTime = dateFormat.parse(data);
            time =  (beginTime.getTime() - currentTime.getTime()) / (1000);// 时间差 单位秒
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 设定显示文字
     */
    public static String getDisplayString(long time) {
        String txt = null;
        if (time >= 0) {
            long day = time / (24 * 3600);// 天
            long hour = time % (24 * 3600) / 3600;// 小时
            long minute = time % 3600 / 60;// 分钟
            long second = time % 60;// 秒

            txt = day + "天" + hour + "小时" + minute + "分" + second + "秒";
        } else {
            txt = "";
        }
        return txt;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        setText(mText);
        super.onDraw(canvas);
    }

}
