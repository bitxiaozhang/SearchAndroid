package com.search.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhang shuailing on 2016/4/26.
 * email bitxiaozhang@163.com
 */
public class WatchView extends View {

    private Paint mPaint ;
    public WatchView(Context context) {
        this(context, null);
    }

    public WatchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WatchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(canvas.getWidth() / 2, 200);
        canvas.drawCircle(0, 0, 100, mPaint);

        canvas.save();
        canvas.translate(-75, -75);
        Path path = new Path();
        path.addArc(new RectF(0, 0, 150, 150), -180, 180);
        Paint citePaint = new Paint(mPaint);
        citePaint.setStrokeWidth(1);
        canvas.drawTextOnPath("牛逼大转盘", path, 90, 0, citePaint);
        canvas.restore();

        Paint tmpPaint = new Paint(mPaint);
        tmpPaint.setStrokeWidth(1);

        float y = 100;
        int count = 60;

        for (int i =0;i<count ; i++){
            if (i%5 == 0){
                canvas.drawLine(0f,y,0,y+12f,mPaint);
                canvas.drawText(String.valueOf(i/5+1), -4f, y+25f, tmpPaint);
            }else{
                canvas.drawLine(0f, y, 0f, y +5f, tmpPaint);
            }
            canvas.rotate(360/count,0f,0f); //旋转画纸
        }

        //绘制指针
        tmpPaint.setColor(Color.GRAY);
        tmpPaint.setStrokeWidth(4);
        canvas.drawCircle(0, 0, 7, tmpPaint);
        tmpPaint.setStyle(Paint.Style.FILL);
        tmpPaint.setColor(Color.YELLOW);
        canvas.drawCircle(0, 0, 5, tmpPaint);
        canvas.drawLine(0, 10, 0, -65, mPaint);
    }
}
