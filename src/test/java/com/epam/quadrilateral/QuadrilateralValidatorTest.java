package com.epam.quadrilateral;

import org.junit.Assert;
import org.junit.Test;

public class QuadrilateralValidatorTest {
    private static final String VALID_LINE_EIGHT_VALUES = "4.5 -3 57.7 -3 1 4 5 -8";
    private static final String INVALID_LINE_EIGHT_VALUES = "8 1 1 5 8 6 8 10";
    private static final String INVALID_LINE_INVALID_NUMBER_OF_VALUES = "1 1 1 1 1 1";
    private static final String INVALID_LINE_INVALID_SYMBOL_EMBEDDED_IN_NUMBER = "4.5 -3 57.7x -3 1 4 5 -8";
    private static final String INVALID_LINE_INVALID_SYMBOL_SEPARATE_FROM_NUMBERS = "4.5 -3 57.7 -3 1 abc 4 5";

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
    public void testIsQuadrilateralShouldReturnFalseWhenInvalidLineEightValues() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(INVALID_LINE_EIGHT_VALUES);

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

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenInvalidLineInvalidSymbolEmbeddedInNumber() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(INVALID_LINE_INVALID_SYMBOL_EMBEDDED_IN_NUMBER);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsQuadrilateralShouldReturnFalseWhenInvalidLineInvalidSymbolSeparateFromNumbers() {
        //given
        QuadrilateralValidator validator = new QuadrilateralValidator();

        //when
        boolean result = validator.isQuadrilateral(INVALID_LINE_INVALID_SYMBOL_SEPARATE_FROM_NUMBERS);

        //then
        Assert.assertFalse(result);
    }
}