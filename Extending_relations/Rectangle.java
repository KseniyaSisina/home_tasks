package com.company;

/**
 * Created by Ксения on 16.11.2016.
 */
public class Rectangle extends Square {
    private double length2;
    public Rectangle(double x, double y, double length1, double length2) {
        super.x = x;
        super.y = y;
        super.length1 = length1;
        this.length2 = length2;
    }
    public double calcSquare() {
        return length1 * length2;
    }
    public void print() {
        System.out.println("coordinates of the upper left corner: (" + x + " ; " + y + ")");
        System.out.println("length of the rectangle's sides: " + length1 + ", " + length2);
        double s = calcSquare();
        System.out.println("square of the rectangle: " + s);
    }
}
