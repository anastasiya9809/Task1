package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testIsCircleShouldReturnTrueWhenRadiusPositive() {
        //given
        Calculator calculator = new Calculator();

        //when
        boolean result = calculator.isCircle(2.5);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenRadiusZero() {
        //given
        Calculator calculator = new Calculator();

        //when
        boolean result = calculator.isCircle(0);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenRadiusNegative() {
        //given
        Calculator calculator = new Calculator();

        //when
        boolean result = calculator.isCircle(-3);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testCalculateAreaShouldReturnArea() {
        //given
        Calculator calculator = new Calculator();
        Circle circle = new Circle(3.5, 2.5, 53.4);
        double expectedResult = Math.PI * 12.25;

        //when
        double result = calculator.calculateArea(circle);

        //then
        Assert.assertEquals(expectedResult, result, 0.0);

    }

    @Test
    public void testCalculatePerimeterShouldReturnPerimeter() {
        //given
        Calculator calculator = new Calculator();
        Circle circle = new Circle(3.5, 2.5, 53.4);
        double expectedResult = Math.PI * 7;

        //when
        double result = calculator.calculatePerimeter(circle);

        //then
        Assert.assertEquals(expectedResult, result, 0.0);
    }
}