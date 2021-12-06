package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;

public class CircleValidatorTest {
    private static final String LINE = "4.5 3 57.7";
    private static final String INVALID_LINE_X_NOT_DOUBLE = "4.5 3b 57.7";
    private static final String INVALID_LINE_Y_NOT_DOUBLE = "4.5 3 f";
    private static final String INVALID_LINE_RADIUS_NOT_DOUBLE = "ggg 3 57.7";
    private static final String INVALID_LINE_RADIUS_NEGATIVE = "-4.5 3 57.7";
    private static final String INVALID_LINE_RADIUS_ZERO_WITHOUT_DECIMAL_POINT = "0 3 57.7";
    private static final String INVALID_LINE_RADIUS_ZERO_WITH_DECIMAL_POINT = "0.00 3 57.7";

    @Test
    public void testIsCircleShouldReturnTrueWhenArgumentsValid() {
        //given
        CircleValidator validator = new CircleValidator();

        //when
        boolean result = validator.isCircle(LINE);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenXIsNotDouble() {
        //given
        CircleValidator validator = new CircleValidator();

        //when
        boolean result = validator.isCircle(INVALID_LINE_X_NOT_DOUBLE);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenYIsNotDouble() {
        //given
        CircleValidator validator = new CircleValidator();

        //when
        boolean result = validator.isCircle(INVALID_LINE_Y_NOT_DOUBLE);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenRadiusIsNotDouble() {
        //given
        CircleValidator validator = new CircleValidator();

        //when
        boolean result = validator.isCircle(INVALID_LINE_RADIUS_NOT_DOUBLE);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenRadiusNegative() {
        //given
        CircleValidator validator = new CircleValidator();

        //when
        boolean result = validator.isCircle(INVALID_LINE_RADIUS_NEGATIVE);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenRadiusIsZeroWithoutDecimalPoint() {
        //given
        CircleValidator validator = new CircleValidator();

        //when
        boolean result = validator.isCircle(INVALID_LINE_RADIUS_ZERO_WITHOUT_DECIMAL_POINT);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenRadiusIsZeroWithDecimalPoint() {
        //given
        CircleValidator validator = new CircleValidator();

        //when
        boolean result = validator.isCircle(INVALID_LINE_RADIUS_ZERO_WITH_DECIMAL_POINT);

        //then
        Assert.assertFalse(result);
    }
}