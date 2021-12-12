package com.epam.quadrilateral;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuadrilateralValidator {
    private static final String REGEX = "^(-?(\\d|(\\d+\\.?\\d+))\\s){7}(-?(\\d|(\\d+\\.?\\d+)))$";
    private static final String SEPARATOR = " ";

    public boolean isQuadrilateral(String line){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(line);
        boolean matchesRegex = matcher.find();

        if (!matchesRegex){
            return false;
        }

        String[] values = line.split(SEPARATOR);

        double xPointA = Double.parseDouble(values[0]);
        double yPointA = Double.parseDouble(values[1]);
        double xPointB = Double.parseDouble(values[2]);
        double yPointB = Double.parseDouble(values[3]);
        double xPointC = Double.parseDouble(values[4]);
        double yPointC = Double.parseDouble(values[5]);
        double xPointD = Double.parseDouble(values[6]);
        double yPointD = Double.parseDouble(values[7]);

        Calculator calculator = new Calculator();

        Point pointA = new Point(xPointA, yPointA);
        Point pointB = new Point(xPointB, yPointB);
        Point pointC = new Point(xPointC, yPointC);
        Point pointD = new Point(xPointD, yPointD);

        return calculator.isQuadrilateral(pointA, pointB, pointC, pointD);
    }
}
