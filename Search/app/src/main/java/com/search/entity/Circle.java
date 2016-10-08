package com.search.entity;

/**
 * Created by zhang shuailing on 2016/4/28.
 * email bitxiaozhang@163.com
 */
public class Circle {
    int xPosition; //圆心坐标x
    int yPosition; //圆心坐标y
    int radius; // 圆半径

    public Circle(int radius, int xPosition, int yPosition) {
        this.radius = radius;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
