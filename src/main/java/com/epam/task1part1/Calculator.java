package com.epam.task1part1;

public class Calculator {
    public boolean isCircle(double radius) {
        return radius > 0;
    }

    public double calculateArea(Circle circle) {
        double radius = circle.getRadius();
        return Math.PI * Math.pow(radius, 2);
    }

    public double calculatePerimeter(Circle circle) {
        double radius = circle.getRadius();
        return 2 * Math.PI * radius;
    }
}
