package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;

public class CircleCreatorTest {
    private static final String LINE = "3.5 4.5 4";
    private static final String INVALID_LINE = "-3.5 4.5 4";

    @Test
    public void testCreateShouldCreateCircleWhenLineValid() {
        //given
        CircleCreator creator = new CircleCreator();

        //when
        Circle expected = new Circle(3.5, 4.5, 4);
        Circle result = creator.create(LINE);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCreateShouldCreateCircleWhenLineInvalid() {
        //given
        CircleCreator creator = new CircleCreator();

        //when
        Circle expected = new Circle(-3.5, 4.5, 4);
        Circle result = creator.create(INVALID_LINE);

        //then
        Assert.assertEquals(expected, result);
    }
}