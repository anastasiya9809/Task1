package com.epam.quadrilateral.repository;

import com.epam.quadrilateral.QuadrilateralObservable;
import com.epam.quadrilateral.entity.Point;

public class CoordinateSpecification implements Specification {

    public boolean isPointInFirstQuadrant(Point point) {
        double xPoint = point.getX();
        double yPoint = point.getY();
        return xPoint > 0 && yPoint > 0;
    }

    @Override
    public boolean specified(QuadrilateralObservable quadrilateral) {
        Point pointA = quadrilateral.getPointA();
        Point pointB = quadrilateral.getPointB();
        Point pointC = quadrilateral.getPointC();
        Point pointD = quadrilateral.getPointD();

        return isPointInFirstQuadrant(pointA) && isPointInFirstQuadrant(pointB) &&
                isPointInFirstQuadrant(pointC) && isPointInFirstQuadrant(pointD);
    }
}
