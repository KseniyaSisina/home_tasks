package com.company;

/**
 * Created by Ксения on 20.11.2016.
 */
public class Rectangle1 extends Square1 {
    private double length1;
    private double length2;
    public Rectangle1(double x, double y, double x1, double y1, double length2) {
        super(x, y, x1, y1);
        this.length1 = super.calcLength();
        this.length2 = length2;
    }
    public double calcSquare() {
        return length1 * length2;
    }
    public void print() {
        System.out.println("coordinates of the one corner: (" + x + " ; " + y + ")");
        System.out.println("coordinates of the other corner: (" + x1 + " ; " + y1 + ")");
        System.out.println("length of the rectangle's sides: " + length1 + ", " + length2);
        double s = calcSquare();
        System.out.println("square of the rectangle: " + s);
    }
}
