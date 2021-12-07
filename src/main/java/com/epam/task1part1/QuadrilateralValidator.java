package com.epam.task1part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuadrilateralValidator {
    private static final String FIRST_REGEX = "^(((\\d|(\\d+\\.?\\d+))\\s){3}(\\d|(\\d+\\.?\\d+))|"
            +"(-?(\\d|(\\d+\\.?\\d+))\\s){7}(-?(\\d|(\\d+\\.?\\d+))))$";
    private static final String SECOND_REGEX = "^(-?(\\d|(\\d+\\.?\\d+))\\s){8}(\\d|(\\d+\\.?\\d+))$";
    private static final String THIRD_REGEX = "^(-?(\\d|(\\d+\\.?\\d+))\\s){8}((\\d|(\\d+\\.?\\d+))\\s)(\\d|(\\d+\\.?\\d+))$";

    private static final String SEPARATOR = " ";

    public boolean isQuadrilateral(String line){
        Pattern firstPattern = Pattern.compile(FIRST_REGEX);
        Matcher firstMatcher = firstPattern.matcher(line);
        boolean matchesFirstRegex = firstMatcher.find();

        Pattern secondPattern = Pattern.compile(SECOND_REGEX);
        Matcher secondMatcher = secondPattern.matcher(line);
        boolean matchesSecondRegex = secondMatcher.find();

        Pattern thirdPattern = Pattern.compile(THIRD_REGEX);
        Matcher thirdMatcher = thirdPattern.matcher(line);
        boolean matchesThirdRegex = thirdMatcher.find();

        if (!(matchesFirstRegex || matchesSecondRegex || matchesThirdRegex)){
            return false;
        }

        String[] values = line.split(SEPARATOR);

        if (values.length == 4){
            double angleA = Double.parseDouble(values[0]);
            double angleB = Double.parseDouble(values[1]);
            double angleC = Double.parseDouble(values[2]);
            double angleD = Double.parseDouble(values[3]);

            boolean isAngleAValid = isAngleValid(angleA);
            boolean isAngleBValid = isAngleValid(angleB);
            boolean isAngleCValid = isAngleValid(angleC);
            boolean isAngleDValid = isAngleValid(angleD);

            return isAngleAValid && isAngleBValid && isAngleCValid &&
                    isAngleDValid;
        }

        if (values.length >= 9){
            double angleA = Double.parseDouble(values[8]);
            boolean isAngleAValid = isAngleValid(angleA);
            if (!isAngleAValid){
                return false;
            }

            if (values.length == 10){
                double angleC = Double.parseDouble(values[9]);
                boolean isAngleCValid = isAngleValid(angleC);
                if (!isAngleCValid){
                    return false;
                }
            }
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

        Calculator calculator = new Calculator();

        return calculator.isQuadrilateral(pointA, pointB, pointC, pointD);
    }

    public boolean isAngleValid(double angle){
        return !(angle >= 2 * Math.PI || angle == Math.PI || angle <= 0);
    }

}
