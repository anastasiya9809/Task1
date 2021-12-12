package com.epam.quadrilateral.repository;

import com.epam.quadrilateral.QuadrilateralObservable;
import com.epam.quadrilateral.logic.Calculator;

public class AreaSpecification implements Specification {

    private final double areaLowerBound;
    private final double areaUpperBound;
    private final Calculator calculator;

    public AreaSpecification(double areaLowerBound, double areaUpperBound, Calculator calculator) {
        this.areaLowerBound = areaLowerBound;
        this.areaUpperBound = areaUpperBound;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(QuadrilateralObservable quadrilateral) {
        double area = calculator.calculateArea(quadrilateral);
        return area >= areaLowerBound && area <= areaUpperBound;
    }
}
