package com.epam.quadrilateral.repository;

import com.epam.quadrilateral.QuadrilateralObservable;
import com.epam.quadrilateral.entity.Point;

import java.util.Comparator;

public class XCoordinateFirstPointComparator implements Comparator<QuadrilateralObservable> {

    @Override
    public int compare(QuadrilateralObservable firstQuadrilateral, QuadrilateralObservable secondQuadrilateral) {
        Point pointAFirstQuadrilateral = firstQuadrilateral.getPointA();
        Point pointASecondQuadrilateral = secondQuadrilateral.getPointA();

        return Double.compare(pointAFirstQuadrilateral.getX(), pointASecondQuadrilateral.getX());
    }
}
