package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;

public class CircleCreatorTest {

    @Test
    public void testCreateShouldCreateCircle() {
        //given
        CircleCreator creator = new CircleCreator();
        String line = "3.5 4.5 4";
        Circle expected = new Circle(3.5, 4.5, 4);

        //when
        Circle result = creator.create(line);

        //then
        Assert.assertEquals(expected, result);
    }
}