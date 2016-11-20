package com.company;

/**
 * Created by Ксения on 16.11.2016.
 */
public class Square extends Point{
    protected double length1;
    public Square(double x, double y, double length1) {
        super(x, y);
        this.length1 = length1;
    }
    public Square() {

    }
    public double calcSquare() {
        return length1 * length1;
    }
    public void print() {
        System.out.println("coordinates of the upper left corner: (" + x + " ; " + y + ")");
        System.out.println("length of the square's side: " + length1);
        double s = calcSquare();
        System.out.println("square of the square: " + s);
    }
}
