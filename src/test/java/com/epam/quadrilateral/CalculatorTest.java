package com.epam.quadrilateral;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final Calculator CALCULATOR = new Calculator();

    @Test
    public void testCalculatePerimeterShouldCalculatePerimeterWhenQuadrilateralConvex() {
        //given
        Point pointA = new Point(5, 6);
        Point pointB = new Point(7, -1);
        Point pointC = new Point(-3, 1);
        Point pointD = new Point(-1, 4);
        Quadrilateral quadrilateral = new Quadrilateral(pointA, pointB, pointC, pointD);

        //when
        double expected = 27.408;
        double result = CALCULATOR.calculatePerimeter(quadrilateral);

        //then
        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void testCalculatePerimeterShouldCalculatePerimeterWhenQuadrilateralConcave() {
        //given
        Point pointA = new Point(5, 6);
        Point pointB = new Point(7, -1);
        Point pointC = new Point(4, 3);
        Point pointD = new Point(-1, 4);
        Quadrilateral quadrilateral = new Quadrilateral(pointA, pointB, pointC, pointD);

        //when
        double expected = 23.704;
        double result = CALCULATOR.calculatePerimeter(quadrilateral);

        //then
        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void testCalculateAreaShouldCalculateAreaWhenQuadrilateralConvex() {
        //given
        Point pointA = new Point(-3, 1);
        Point pointB = new Point(-1, 4);
        Point pointC = new Point(5, 6);
        Point pointD = new Point(7, -1);

        Quadrilateral quadrilateral = new Quadrilateral(pointA, pointB, pointC, pointD);

        //when
        double expected = 40;
        double result = CALCULATOR.calculateArea(quadrilateral);

        //then
        Assert.assertEquals(expected, result, 0.01);
    }

    @Test
    public void testCalculateAreaShouldCalculateAreaWhenQuadrilateralConcave() {
        //given
        Point pointA = new Point(4, 3);
        Point pointB = new Point(-1, 4);
        Point pointC = new Point(5, 6);
        Point pointD = new Point(7, -1);
        Quadrilateral quadrilateral = new Quadrilateral(pointA, pointB, pointC, pointD);

        //when
        double expected = 14.5;
        double result = CALCULATOR.calculateArea(quadrilateral);

        //then
        Assert.assertEquals(expected, result, 0.01);
    }

    @Test
    public void testIsQuadrilateralShouldReturnTrueWhenQuadrilateralConvex() {
        //given
        Point pointA = new Point(5, 6);
        Point pointB = new Point(7, -1);
        Point pointC = new Point(-3, 1);
        Point pointD = new Point(-1, 4);

        //when
        boolean result = CALCULATOR.isQuadrilateral(pointA, pointB, pointC, pointD);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnTrueWhenQuadrilateralConcave() {
        //given
        Point pointA = new Point(5, 6);
        Point pointB = new Point(7, -1);
        Point pointC = new Point(4, 3);
        Point pointD = new Point(-1, 4);

        //when
        boolean result = CALCULATOR.isQuadrilateral(pointA, pointB, pointC, pointD);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenNotQuadrilateralABCOnSameLine() {
        //given
        Point pointA = new Point(1, 3);
        Point pointB = new Point(4, 3);
        Point pointC = new Point(7, 3);
        Point pointD = new Point(-1, 4);

        //when
        boolean result = CALCULATOR.isQuadrilateral(pointA, pointB, pointC, pointD);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenNotQuadrilateralABDOnSameLine() {
        //given
        Point pointA = new Point(2, 6);
        Point pointB = new Point(2, 8);
        Point pointC = new Point(4, 3);
        Point pointD = new Point(2, 4);

        //when
        boolean result = CALCULATOR.isQuadrilateral(pointA, pointB, pointC, pointD);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenNotQuadrilateralACDOnSameLine() {
        //given
        Point pointA = new Point(2, 2);
        Point pointB = new Point(7, -1);
        Point pointC = new Point(0, 0);
        Point pointD = new Point(1, 1);

        //when
        boolean result = CALCULATOR.isQuadrilateral(pointA, pointB, pointC, pointD);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenNotQuadrilateralBCDOnSameLine() {
        //given
        Point pointA = new Point(5, 6);
        Point pointB = new Point(0, 0);
        Point pointC = new Point(-1, 1);
        Point pointD = new Point(-2, 2);

        //when
        boolean result = CALCULATOR.isQuadrilateral(pointA, pointB, pointC, pointD);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsConvexShouldReturnTrueWhenQuadrilateralConvex() {
        //given
        Point pointA = new Point(5, 6);
        Point pointB = new Point(7, -1);
        Point pointC = new Point(-3, 1);
        Point pointD = new Point(-1, 4);
        Quadrilateral quadrilateral = new Quadrilateral(pointA, pointB, pointC, pointD);

        //when
        boolean result = CALCULATOR.isConvex(quadrilateral);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsConvexShouldReturnFalseWhenQuadrilateralConcave() {
        //given
        Point pointA = new Point(5, 6);
        Point pointB = new Point(7, -1);
        Point pointC = new Point(4, 3);
        Point pointD = new Point(-1, 4);

        Quadrilateral quadrilateral = new Quadrilateral(pointA, pointB, pointC, pointD);

        //when
        boolean result = CALCULATOR.isConvex(quadrilateral);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsSquareShouldReturnTrueWhenQuadrilateralIsSquareRotated() {
        //given
        Quadrilateral quadrilateral = new Quadrilateral(new Point(0, 0), new Point(2, 2),
                new Point(4, 0), new Point(2, -2));

        //when
        boolean result = CALCULATOR.isSquare(quadrilateral);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsSquareShouldReturnTrueWhenQuadrilateralIsSquareNotRotated() {
        //given
        Quadrilateral quadrilateral = new Quadrilateral(new Point(0, 4), new Point(4, 4),
                new Point(4, 0), new Point(0, 0));

        //when
        boolean result = CALCULATOR.isSquare(quadrilateral);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsSquareShouldReturnFalseWhenQuadrilateralIsNotSquare() {
        //given
        Quadrilateral quadrilateral = new Quadrilateral(new Point(0, 0), new Point(2, 2),
                new Point(5, 0), new Point(2, -2));

        //when
        boolean result = CALCULATOR.isSquare(quadrilateral);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsRhombusShouldReturnTrueWhenQuadrilateralIsRhombus() {
        //given
        Quadrilateral quadrilateral = new Quadrilateral(new Point(0, 0), new Point(2, 1),
                new Point(4, 0), new Point(2, -1));

        //when
        boolean result = CALCULATOR.isRhombus(quadrilateral);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsRhombusShouldReturnFalseWhenQuadrilateralIsNotRhombus() {
        //given
        Quadrilateral quadrilateral = new Quadrilateral(new Point(0, 0), new Point(2, 1),
                new Point(4, 0), new Point(2, -2));

        //when
        boolean result = CALCULATOR.isRhombus(quadrilateral);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsTrapezoidShouldReturnTrueWhenQuadrilateralIsTrapezoid() {
        //given
        Quadrilateral quadrilateral = new Quadrilateral(new Point(2, 0), new Point(7, 0),
                new Point(10, -3), new Point(0, -3));

        //when
        boolean result = CALCULATOR.isTrapezoid(quadrilateral);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsTrapezoidShouldReturnFalseWhenQuadrilateralIsNotTrapezoid() {
        //given
        Quadrilateral quadrilateral = new Quadrilateral(new Point(2, 0), new Point(7, 2),
                new Point(10, -3), new Point(0, -3));

        //when
        boolean result = CALCULATOR.isTrapezoid(quadrilateral);

        //then
        Assert.assertFalse(result);
    }
}