package com.epam.task1part1;

public class QuadrilateralCreator {
    private final static String SEPARATOR = " ";

    public Quadrilateral create(String line) {
        String[] values = line.split(SEPARATOR);
        int length = values.length;

        if (length == 4) {
            double angleA = Double.parseDouble(values[0]);
            double angleB = Double.parseDouble(values[1]);
            double angleC = Double.parseDouble(values[2]);
            double angleD = Double.parseDouble(values[3]);

            return new Quadrilateral(angleA, angleB, angleC, angleD);
        }

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

        if (length == 8) {
            return new Quadrilateral(pointA, pointB, pointC, pointD);
        }
        else {
            double angleA = Double.parseDouble(values[8]);
            if (length == 9) {
                return new Quadrilateral(pointA, pointB, pointC, pointD, angleA);
            }

            double angleB = Double.parseDouble(values[9]);
            return new Quadrilateral(pointA, pointB, pointC, pointD, angleA, angleB);
        }
    }
}
