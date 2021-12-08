package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;

public class QuadrilateralCreatorTest {
    private static final QuadrilateralCreator creator = new QuadrilateralCreator();
    private static final String FIRST_LINE = "2 1.7 1.35 1.23 4 6.7 4.6 3.5";
    private static final String SECOND_LINE = "0 0 2 2 4 0 2 -2";

    @Test
    public void testCreateShouldCreateQuadrilateralWhenLineHasDecimalNumbers() {
        //when
        Quadrilateral expected = new Quadrilateral(new Point(2, 1.7),
                new Point(1.35, 1.23), new Point(4, 6.7), new Point(4.6, 3.5));
        Quadrilateral result = creator.create(FIRST_LINE);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCreateShouldCreateQuadrilateralWhenLineHasWholeNumbersOnly() {
        //when
        Quadrilateral expected = new Quadrilateral(new Point(0, 0), new Point(2, 2),
                new Point(4, 0), new Point(2, -2));
        Quadrilateral result = creator.create(SECOND_LINE);

        //then
        Assert.assertEquals(expected, result);
    }
}