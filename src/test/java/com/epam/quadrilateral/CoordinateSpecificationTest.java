package com.epam.quadrilateral;

import com.epam.quadrilateral.entity.Point;
import com.epam.quadrilateral.repository.CoordinateSpecification;
import org.junit.Assert;
import org.junit.Test;

public class CoordinateSpecificationTest {

    private static final CoordinateSpecification SPECIFICATION = new CoordinateSpecification();

    @Test
    public void testSpecifiedShouldReturnTrueWhenAllFourPointsInFirstQuadrant() {
        //given
        Point pointA = new Point(5, 6);
        Point pointB = new Point(7, 1);
        Point pointC = new Point(3, 2);
        Point pointD = new Point(1, 4);
        QuadrilateralObservable quadrilateral = new QuadrilateralObservable(3, pointA, pointB, pointC, pointD);

        //when
        boolean result = SPECIFICATION.specified(quadrilateral);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenNotAllFourPointsInFirstQuadrant() {
        //given
        Point pointA = new Point(5, 6);
        Point pointB = new Point(7, 1);
        Point pointC = new Point(3, 2);
        Point pointD = new Point(1, -4);
        QuadrilateralObservable quadrilateral = new QuadrilateralObservable(3, pointA, pointB, pointC, pointD);

        //when
        boolean result = SPECIFICATION.specified(quadrilateral);

        //then
        Assert.assertFalse(result);
    }
}