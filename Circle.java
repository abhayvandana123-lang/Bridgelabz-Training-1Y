package com.gla;

class Circle {

    double radius;

    Circle() {
        this(1.0);
    }

    Circle(double radius) {
        this.radius = radius;
    }
}

public class Main {
    public static void main(String[] args) {

        Circle c1 = new Circle();
        System.out.println(c1.radius);

        Circle c2 = new Circle(5.5);
        System.out.println(c2.radius);
    }
}
