package com.epam.quadrilateral;

import com.epam.quadrilateral.entity.Point;
import com.epam.quadrilateral.logic.Calculator;
import com.epam.quadrilateral.repository.AreaSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class AreaSpecificationTest {

    @Test
    public void testSpecifiedShouldReturnTrueWhenAreaWithinRange() {
        //given
        Point pointA = new Point(5, 6);
        Point pointB = new Point(7, -1);
        Point pointC = new Point(4, 3);
        Point pointD = new Point(-1, 4);
        QuadrilateralObservable quadrilateral = new QuadrilateralObservable(3, pointA, pointB, pointC, pointD);

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.calculateArea(quadrilateral)).thenReturn(23.704);

        AreaSpecification specification = new AreaSpecification(16, 25,
                calculator);

        //when
        boolean result = specification.specified(quadrilateral);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenAreaOutOfRange() {
        //given
        Point pointA = new Point(5, 6);
        Point pointB = new Point(7, -1);
        Point pointC = new Point(-3, 1);
        Point pointD = new Point(-1, 4);
        QuadrilateralObservable quadrilateral = new QuadrilateralObservable(3, pointA, pointB, pointC, pointD);

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.calculateArea(quadrilateral)).thenReturn(27.408);

        AreaSpecification specification = new AreaSpecification(16, 25,
                calculator);

        //when
        boolean result = specification.specified(quadrilateral);

        //then
        Assert.assertFalse(result);
    }
}