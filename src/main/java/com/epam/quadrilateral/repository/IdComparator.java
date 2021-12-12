package com.epam.quadrilateral.repository;

import com.epam.quadrilateral.QuadrilateralObservable;

import java.util.Comparator;

public class IdComparator implements Comparator<QuadrilateralObservable> {

    @Override
    public int compare(QuadrilateralObservable firstQuadrilateral, QuadrilateralObservable secondQuadrilateral) {
        return Double.compare(firstQuadrilateral.getId(), secondQuadrilateral.getId());
    }
}
