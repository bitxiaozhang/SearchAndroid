package com.search.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.search.entity.Circle;

/**
 * Created by zhang shuailing on 2016/4/28.
 * email bitxiaozhang@163.com
 */
public class WaterView extends View {

    private int viewWidth;
    private int viewHeight;

    private Circle bigCircle;
    private Circle smallCicle;
    private int bigRadius = 35;
    private int smallRadius = 20;
    private Paint mPaint;
    private int yDelay;
    private Path path;

    private int middleSmallY;
    private int middleBigY;

    private boolean isDrawMiddle = true;

    public WaterView(Context context) {
        this(context, null);

    }

    public WaterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        bigCircle = new Circle(bigRadius, viewWidth / 2, bigRadius);
        smallCicle = new Circle(smallRadius, viewWidth / 2, smallRadius);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        viewWidth = getWidth();

        bigCircle.setxPosition(viewWidth / 2);
        smallCicle.setxPosition(viewWidth / 2);

        yDelay += 5;

        if (yDelay < 5 * bigRadius) {
            isDrawMiddle = true;
        }else {
            isDrawMiddle = false;
        }

        if (yDelay > 300) {
            yDelay = 0;
        }

        bigCircle.setyPosition(2 * smallRadius + yDelay);

        middleBigY = bigCircle.getyPosition() - bigRadius;
        middleSmallY = smallCicle.getyPosition() + smallRadius;

        if (isDrawMiddle) {
            path.reset();
            path.moveTo(viewWidth / 2 - smallRadius, smallCicle.getyPosition());
            path.addArc(new RectF(smallCicle.getxPosition() - smallRadius, 0, viewWidth / 2 + smallRadius, smallCicle.getyPosition() + smallRadius), -180, 180);
            path.cubicTo(viewWidth / 2, middleSmallY, viewWidth / 2, middleBigY, viewWidth / 2 + bigRadius, bigCircle.getyPosition());
            path.addArc(new RectF(bigCircle.getxPosition() - bigRadius, bigCircle.getyPosition() - bigRadius, bigCircle.getxPosition() + bigRadius, bigCircle.getyPosition() + bigRadius), 0, 180);
            path.cubicTo(viewWidth / 2, middleBigY, viewWidth / 2, middleSmallY, smallCicle.getxPosition() - smallRadius, smallCicle.getyPosition());
            path.close();
            canvas.drawPath(path, mPaint);
        }

        canvas.drawCircle(smallCicle.getxPosition(), smallCicle.getyPosition(), smallRadius, mPaint);
        canvas.drawCircle(bigCircle.getxPosition(), bigCircle.getyPosition(), bigRadius, mPaint);

        invalidate();
    }
}
