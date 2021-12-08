package com.epam.task1part1;

public class Quadrilateral {
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private final Point pointD;

    public Quadrilateral(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Quadrilateral)) {
            return false;
        }

        Quadrilateral other = (Quadrilateral) obj;

        return this.pointA.equals(other.pointA) && this.pointB.equals(other.pointB) &&
                this.pointC.equals(other.pointC) && this.pointD.equals(other.pointD);
    }
}