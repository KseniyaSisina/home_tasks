package com.company;

/**
 * Created by Ксения on 16.11.2016.
 */
import java.util.*;

public class Line extends Point {
    protected double x1;
    protected double y1;
    public Line(double x, double y, double x1, double y1) {
        super(x, y);
        this.x1 = x1;
        this.y1 = y1;
    }
    public Line() {

    }
    public double calcLength() {
        return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
    }
    public void print() {
        System.out.println("equation of straight line: (x - " + x + ")/" + (x1 - x) + " = (y - " + y + ")/" + (y1 - y));
        double l = calcLength();
        System.out.println("length of line's segment: " + l);
    }
}
