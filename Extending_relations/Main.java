package com.company;

public class Main {

    public static void main(String[] args) {
        Point t = new Point(1.0, 1.0);
        t.print();
        System.out.println("---------------");
        Line l = new Line(0.0, 3.0, 4.0, 0.0);
        l.print();
        System.out.println("---------------");
        Square k = new Square(-3.0, 2.0, 5.3);
        k.print();
        System.out.println("---------------");
        Rectangle p = new Rectangle(-3.5, 2.4, 3.2, 1.3);
        p.print();
        System.out.println("---------------");
        Square1 k1 = new Square1(-3.0, 2.0, 5.3, 4.1);
        k1.print();
        System.out.println("---------------");
        Rectangle1 p1 = new Rectangle1(-3.0, 2.0, 5.3, 4.1, 10.0);
        p1.print();
    }
}
