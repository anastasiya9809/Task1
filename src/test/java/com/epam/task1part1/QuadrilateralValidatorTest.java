package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;

public class QuadrilateralValidatorTest {
    private static final String VALID_LINE_TEN_VALUES = "4.5 -3 57.7 3 1 -4 -5 8 1 5";
    private static final String VALID_LINE_NINE_VALUES = "4.5 -3 57.7 -3 1 -4 5 8 3.14";
    private static final String VALID_LINE_EIGHT_VALUES = "4.5 -3 57.7 -3 1 4 5 -8";
    private static final String VALID_LINE_FOUR_VALUES= "3 3 0.14 0.14";
    private static final String INVALID_LINE_TEN_VALUES_POINTS_INVALID = "1 1 2 2 3 3 5 8 1 5";
    private static final String INVALID_LINE_NINE_VALUES_POINTS_INVALID = "2 4 3 4 8 9 4 4 3.14";
    private static final String INVALID_LINE_TEN_VALUES_ANGLE_INVALID = "1 1 2 3 4 9 5 8 1 0";
    private static final String INVALID_LINE_NINE_VALUES_ANGLE_INVALID = "2 4 3 9 8 10 4 -1 -1";
    private static final String INVALID_LINE_EIGHT_VALUES = "8 1 1 5 8 6 8 10";
    private static final String INVALID_LINE_FOUR_VALUES = "7 1 1 1";
    private static final String INVALID_LINE_INVALID_NUMBER_OF_VALUES = "1 1 1 1 1 1";

    @Test
    public void testIsQuadrilateralShouldReturnTrueWhenValidLineTenValues() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(VALID_LINE_TEN_VALUES);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnTrueWhenValidLineNineValues() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(VALID_LINE_NINE_VALUES);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnTrueWhenValidLineEightValues() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(VALID_LINE_EIGHT_VALUES);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnTrueWhenValidLineFourValues() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(VALID_LINE_FOUR_VALUES);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenInvalidLineTenValues() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(INVALID_LINE_TEN_VALUES_POINTS_INVALID);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenInvalidLineNineValuesPointsInvalid() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(INVALID_LINE_NINE_VALUES_POINTS_INVALID);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenInvalidLineTenValuesAngleInvalid() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(INVALID_LINE_TEN_VALUES_ANGLE_INVALID);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenInvalidLineNineValuesAngleInvalid() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(INVALID_LINE_NINE_VALUES_ANGLE_INVALID);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenInvalidLineEightValues() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(INVALID_LINE_EIGHT_VALUES);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenInvalidLineFourValues() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(INVALID_LINE_FOUR_VALUES);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenInvalidLineInvalidNumberOfValues() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(INVALID_LINE_INVALID_NUMBER_OF_VALUES);

        //then
        Assert.assertFalse(result);
    }
}