package com.company;

/**
 * Created by Ксения on 20.11.2016.
 */
public class Square1 extends Line {
    protected double length1;
    public Square1(double x, double y, double x1, double y1) {
        super(x, y, x1, y1);
        this.length1 = super.calcLength();
    }
    public Square1() {

    }
    public double calcSquare() {
        return length1 * length1;
    }
    public void print() {
        System.out.println("coordinates of the one corner: (" + x + " ; " + y + ")");
        System.out.println("coordinates of the other corner: (" + x1 + " ; " + y1 + ")");
        System.out.println("length of the square's side: " + length1);
        double s = calcSquare();
        System.out.println("square of the square: " + s);
    }

}
