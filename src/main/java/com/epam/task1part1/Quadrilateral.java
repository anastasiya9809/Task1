package com.epam.task1part1;

public class Quadrilateral {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    private double angleA;
    private double angleB;
    private double angleC;
    private double angleD;

    public Quadrilateral(Point pointA, Point pointB, Point pointC, Point pointD, double angleA,
                         double angleC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.angleA = angleA;
        this.angleC = angleC;
    }

    public Quadrilateral(Point pointA, Point pointB, Point pointC, Point pointD, double angleA) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.angleA = angleA;
    }

    public Quadrilateral(double angleA, double angleB,
                         double angleC, double angleD) {
        this.angleA = angleA;
        this.angleB = angleB;
        this.angleC = angleC;
        this.angleD = angleD;
    }

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

    public double getAngleA() {
        return angleA;
    }

    public double getAngleB() {
        return angleB;
    }

    public double getAngleC() {
        return angleC;
    }

    public double getAngleD() {
        return angleD;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Quadrilateral)) {
            return false;
        }

        Quadrilateral other = (Quadrilateral) obj;

        if (pointA == null){
            return this.angleA == other.angleA && this.angleB == other.angleB
                    && this.angleC == other.angleC
                    && this.angleD == other.angleD;
        }

        return this.pointA.equals(other.pointA) && this.pointB.equals(other.pointB) &&
                this.pointC.equals(other.pointC) && this.pointD.equals(other.pointD)
                && this.angleA == other.angleA && this.angleC == other.angleC;
    }
}