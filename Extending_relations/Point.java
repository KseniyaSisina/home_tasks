package com.company;

/**
 * Created by Ксения on 16.11.2016.
 */
public class Point {
    protected double x;
    protected double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point() {

    }
    public void print() {
        System.out.println("coordinates of the point: (" + x + " ; " + y + ")");
    }
}
