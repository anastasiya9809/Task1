package com.epam.quadrilateral;

public class Calculator {
    private static final double SQUARE_ROOT_TWO = Math.sqrt(2);

    public double calculateDistance(Point firstPoint, Point secondPoint){
        double xFirstPoint = firstPoint.getX();
        double yFirstPoint = firstPoint.getY();

        double xSecondPoint = secondPoint.getX();
        double ySecondPoint = secondPoint.getY();

        double distanceSquared = Math.pow(xSecondPoint - xFirstPoint, 2) +
                Math.pow(ySecondPoint - yFirstPoint, 2);

        return Math.sqrt(distanceSquared);
    }

    public double calculatePerimeter(Quadrilateral quadrilateral) {
        Point pointA = quadrilateral.getPointA();
        Point pointB = quadrilateral.getPointB();
        Point pointC = quadrilateral.getPointC();
        Point pointD = quadrilateral.getPointD();

        double distanceAB = calculateDistance(pointA, pointB);
        double distanceBC = calculateDistance(pointB, pointC);
        double distanceCD = calculateDistance(pointC, pointD);
        double distanceAD = calculateDistance(pointA, pointD);

        return distanceAB + distanceBC + distanceCD + distanceAD;
    }

    public double calculateArea(Quadrilateral quadrilateral) {
        Point pointA = quadrilateral.getPointA();
        Point pointB = quadrilateral.getPointB();
        Point pointC = quadrilateral.getPointC();
        Point pointD = quadrilateral.getPointD();

        double area = 0;
        Point[] points = { pointA, pointB, pointC, pointD };
        int length = points.length;
        for (int i = 0; i < points.length; i++){
            int j = (i + 1) % length;
            area = area + points[i].getX() * points[j].getY();
            area = area - points[i].getY() * points[j].getX();
        }

        return -area / 2;
    }

    public double calculateSlope(Point firstPoint, Point secondPoint) {
        double xFirstPoint = firstPoint.getX();
        double yFirstPoint = firstPoint.getY();

        double xSecondPoint = secondPoint.getX();
        double ySecondPoint = secondPoint.getY();

        if (xFirstPoint == xSecondPoint){
            return Double.POSITIVE_INFINITY;
        }

        return (ySecondPoint - yFirstPoint) / (xSecondPoint - xFirstPoint);
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

    public double calculateCrossProduct(Point A, Point B, Point C){
        double xAB = A.getX() - B.getX();
        double yAB = A.getY() - B.getY();
        double xBC = C.getX() - B.getX();
        double yBC = C.getY() - B.getY();

        return xAB * yBC - yAB * xBC;
    }

    public boolean isConvex(Quadrilateral quadrilateral){
        Point pointA = quadrilateral.getPointA();
        Point pointB = quadrilateral.getPointB();
        Point pointC = quadrilateral.getPointC();
        Point pointD = quadrilateral.getPointD();

        Point[] points = { pointD, pointA, pointB, pointC, pointD, pointA };

        boolean foundOnePositive = false;
        boolean foundOneNegative = false;

        for (int i = 1; i < points.length - 1; i++){
            double crossProduct = calculateCrossProduct(points[i], points[i - 1], points[i + 1]);
            if (i == 1){
                if (crossProduct > 0){
                    foundOnePositive = true;
                }
                if (crossProduct < 0){
                    foundOneNegative = true;
                }
            }
            else {
                if (foundOnePositive && crossProduct < 0){
                    return false;
                }
                if (foundOneNegative && crossProduct > 0){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isSquare(Quadrilateral quadrilateral){
        Point pointA = quadrilateral.getPointA();
        Point pointB = quadrilateral.getPointB();
        Point pointC = quadrilateral.getPointC();
        Point pointD = quadrilateral.getPointD();

        double distanceAB = calculateDistance(pointA, pointB);
        double distanceBC = calculateDistance(pointB, pointC);
        double distanceCD = calculateDistance(pointC, pointD);
        double distanceAD = calculateDistance(pointA, pointD);

        double distanceAC = calculateDistance(pointA, pointC);
        double roundedDistanceAC = Math.round(distanceAC * 100.0) / 100.0;

        double diagonalLengthInSquare = distanceAB * SQUARE_ROOT_TWO;
        double roundedDiagonalLengthInSquare = Math.round(diagonalLengthInSquare * 100.0) / 100.0;

        return distanceAB == distanceBC && distanceBC == distanceCD && distanceCD == distanceAD &&
                roundedDistanceAC == roundedDiagonalLengthInSquare;
    }

    public boolean isRhombus(Quadrilateral quadrilateral){
        Point pointA = quadrilateral.getPointA();
        Point pointB = quadrilateral.getPointB();
        Point pointC = quadrilateral.getPointC();
        Point pointD = quadrilateral.getPointD();

        double distanceAB = calculateDistance(pointA, pointB);
        double distanceBC = calculateDistance(pointB, pointC);
        double distanceCD = calculateDistance(pointC, pointD);
        double distanceAD = calculateDistance(pointA, pointD);

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
}
