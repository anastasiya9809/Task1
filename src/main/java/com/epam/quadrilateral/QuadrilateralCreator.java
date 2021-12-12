package com.epam.quadrilateral;

public class QuadrilateralCreator {
    private final static String SEPARATOR = " ";

    public Quadrilateral create(String line) {
        String[] values = line.split(SEPARATOR);

        double xPointA = Double.parseDouble(values[0]);
        double yPointA = Double.parseDouble(values[1]);
        double xPointB = Double.parseDouble(values[2]);
        double yPointB = Double.parseDouble(values[3]);
        double xPointC = Double.parseDouble(values[4]);
        double yPointC = Double.parseDouble(values[5]);
        double xPointD = Double.parseDouble(values[6]);
        double yPointD = Double.parseDouble(values[7]);

        Point pointA = new Point(xPointA, yPointA);
        Point pointB = new Point(xPointB, yPointB);
        Point pointC = new Point(xPointC, yPointC);
        Point pointD = new Point(xPointD, yPointD);

        return new Quadrilateral(pointA, pointB, pointC, pointD);
    }
}
