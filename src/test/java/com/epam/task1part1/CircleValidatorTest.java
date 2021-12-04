package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;

public class CircleValidatorTest {

    @Test
    public void testIsCircleShouldReturnTrueWhenArgumentsValid() {
        //given
        CircleValidator validator = new CircleValidator();
        String line = "4.5 3 57.7";

        //when
        boolean result = validator.isCircle(line);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenXIsNotDouble() {
        //given
        CircleValidator validator = new CircleValidator();
        String line = "4.5 3b 57.7";

        //when
        boolean result = validator.isCircle(line);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenYIsNotDouble() {
        //given
        CircleValidator validator = new CircleValidator();
        String line = "4.5 3 f";

        //when
        boolean result = validator.isCircle(line);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenRadiusIsNotDouble() {
        //given
        CircleValidator validator = new CircleValidator();
        String line = "ggg 3 57.7";

        //when
        boolean result = validator.isCircle(line);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenRadiusNegative() {
        //given
        CircleValidator validator = new CircleValidator();
        String line = "-4.5 3 57.7";

        //when
        boolean result = validator.isCircle(line);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenRadiusIsZeroWithoutDecimalPoint() {
        //given
        CircleValidator validator = new CircleValidator();
        String line = "0 3 57.7";

        //when
        boolean result = validator.isCircle(line);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenRadiusIsZeroWithDecimalPoint() {
        //given
        CircleValidator validator = new CircleValidator();
        String line = "0.00 3 57.7";

        //when
        boolean result = validator.isCircle(line);

        //then
        Assert.assertFalse(result);
    }
}