package com.epam.task1part1;

public class CircleCreator {
    private final static String SEPARATOR = " ";

    public Circle create(String line) {
        String[] values = line.split(SEPARATOR);

        double radius = Double.parseDouble(values[0]);
        double x = Double.parseDouble(values[1]);
        double y = Double.parseDouble(values[2]);

        return new Circle(radius, x, y);
    }
}
