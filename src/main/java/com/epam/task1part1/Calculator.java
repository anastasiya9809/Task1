package com.epam.task1part1;

public class Calculator {
    public double calculatePerimeter(Quadrilateral quadrilateral) {
        double distanceAB = calculateDistance(quadrilateral, Segment.AB);
        double distanceBC = calculateDistance(quadrilateral, Segment.BC);
        double distanceCD = calculateDistance(quadrilateral, Segment.CD);
        double distanceAD = calculateDistance(quadrilateral, Segment.AD);

        return distanceAB + distanceBC + distanceCD + distanceAD;
    }

    public double calculateArea(Quadrilateral quadrilateral) {
        double distanceAB = calculateDistance(quadrilateral, Segment.AB);
        double distanceBC = calculateDistance(quadrilateral, Segment.BC);
        double distanceCD = calculateDistance(quadrilateral, Segment.CD);
        double distanceAD = calculateDistance(quadrilateral, Segment.AD);

        double angleA = quadrilateral.getAngleA();
        double angleC = quadrilateral.getAngleC();

        return 0.5 * distanceAB * distanceAD * Math.sin(angleA) +
                0.5 * distanceBC * distanceCD * Math.sin(angleC);
    }

    public boolean isQuadrilateral(Point pointA, Point pointB, Point pointC, Point pointD){
        double slopeAB = calculateSlope(pointA, pointB);
        double slopeBC = calculateSlope(pointB, pointC);
        double slopeBD = calculateSlope(pointB, pointD);
        double slopeAC = calculateSlope(pointA, pointC);
        double slopeCD = calculateSlope(pointC, pointD);

        boolean areABCOnSameLine = slopeAB == slopeBC;
        boolean areABDOnSameLine = slopeAB == slopeBD;
        boolean areACDOnSameLine = slopeAC == slopeCD;
        boolean areBCDOnSameLine = slopeBC == slopeCD;

        return !(areABCOnSameLine || areABDOnSameLine || areACDOnSameLine ||
                areBCDOnSameLine);
    }

    public boolean isConvex(Quadrilateral quadrilateral){
        double angleA = quadrilateral.getAngleA();
        double angleB = quadrilateral.getAngleB();
        double angleC = quadrilateral.getAngleC();
        double angleD = quadrilateral.getAngleD();

        return angleA < Math.PI && angleB < Math.PI &&
                angleC < Math.PI && angleD < Math.PI;
    }

    public boolean isSquare(Quadrilateral quadrilateral){
        double distanceAB = calculateDistance(quadrilateral, Segment.AB);
        double distanceBC = calculateDistance(quadrilateral, Segment.BC);
        double distanceCD = calculateDistance(quadrilateral, Segment.CD);
        double distanceAD = calculateDistance(quadrilateral, Segment.AD);

        double angleA = quadrilateral.getAngleA();

        return angleA == Math.PI / 2 && distanceAB == distanceBC && distanceBC == distanceCD && distanceCD == distanceAD;
    }

    public boolean isRhombus(Quadrilateral quadrilateral){
        double distanceAB = calculateDistance(quadrilateral, Segment.AB);
        double distanceBC = calculateDistance(quadrilateral, Segment.BC);
        double distanceCD = calculateDistance(quadrilateral, Segment.CD);
        double distanceAD = calculateDistance(quadrilateral, Segment.AD);

        return distanceAB == distanceBC && distanceBC == distanceCD && distanceCD == distanceAD;
    }

    public boolean isTrapezoid(Quadrilateral quadrilateral){
        Point pointA = quadrilateral.getPointA();
        Point pointB = quadrilateral.getPointB();
        Point pointC = quadrilateral.getPointC();
        Point pointD = quadrilateral.getPointD();

        double slopeAB = calculateSlope(pointA, pointB);
        double slopeBC = calculateSlope(pointB, pointC);
        double slopeCD = calculateSlope(pointC, pointD);
        double slopeAD = calculateSlope(pointA, pointD);

        return slopeAB == slopeCD || slopeBC == slopeAD;
    }

    public double calculateDistance(Quadrilateral quadrilateral, Segment segment){
        Point firstPoint;
        Point secondPoint;

        switch (segment){
            case AB:
                firstPoint = quadrilateral.getPointA();
                secondPoint = quadrilateral.getPointB();
                break;
            case BC:
                firstPoint = quadrilateral.getPointB();
                secondPoint = quadrilateral.getPointC();
                break;
            case CD:
                firstPoint = quadrilateral.getPointC();
                secondPoint = quadrilateral.getPointD();
                break;
            case AD:
                firstPoint = quadrilateral.getPointA();
                secondPoint = quadrilateral.getPointD();
                break;
            case BD:
                firstPoint = quadrilateral.getPointB();
                secondPoint = quadrilateral.getPointD();
                break;
            case AC:
                firstPoint = quadrilateral.getPointA();
                secondPoint = quadrilateral.getPointC();
                break;
            default:
                throw new IllegalArgumentException("segment argument invalid");
        }

        double xFirstPoint = firstPoint.getX();
        double yFirstPoint = firstPoint.getY();

        double xSecondPoint = secondPoint.getX();
        double ySecondPoint = secondPoint.getY();

        double distanceSquared = Math.pow(xSecondPoint - xFirstPoint, 2) +
                Math.pow(ySecondPoint - yFirstPoint, 2);

        return Math.sqrt(distanceSquared);
    }

    public double calculateSlope(Point firstPoint, Point secondPoint) {
        double xFirstPoint = firstPoint.getX();
        double yFirstPoint = firstPoint.getY();

        double xSecondPoint = secondPoint.getX();
        double ySecondPoint = secondPoint.getY();

        if (xFirstPoint == xSecondPoint){
            return 0;
        }

        return (ySecondPoint - yFirstPoint) / (xSecondPoint - xFirstPoint);
    }
}
