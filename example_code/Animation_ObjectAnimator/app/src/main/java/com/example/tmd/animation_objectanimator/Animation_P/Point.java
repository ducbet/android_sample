package com.example.tmd.animation_objectanimator.Animation_P;

/**
 * Created by tmd on 06/04/2017.
 */

public class Point {
    private float X;
    private float Y;

    Point(float X, float Y) {
        this.X = X;
        this.Y = Y;
    }

    Point(Point p) {
        this.X = p.getX();
        this.Y = p.getY();
    }

    Point() {

    }

    public boolean pointEquals(Object p) {
        if (this.X == ((Point) p).getX() && this.Y == ((Point) p).getY()) {
            return true;
        }
        return false;
    }

    public float getX() {
        return X;
    }

    public float getY() {
        return Y;
    }

    public void setX(float x) {
        X = x;
    }

    public void setY(float y) {
        Y = y;
    }
}
