package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;

public class QuadrilateralCreatorTest {
    private static final QuadrilateralCreator creator = new QuadrilateralCreator();

    private static final String LINE_FOUR_VALUES = "2 1.7 1.35 1.23";
    private static final String LINE_EIGHT_VALUES = "2 3 1 4 5 6 9 10";
    private static final String LINE_NINE_VALUES = "2 1 5 5 7 4 4 0 1.57";
    private static final String LINE_TEN_VALUES = "0 0 2 2 4 0 2 -2 1.57 1.57";

    @Test
    public void testCreateShouldCreateQuadrilateralWhenFourValuesInLine() {
        //when
        Quadrilateral expected = new Quadrilateral(2, 1.7, 1.35, 1.23);
        Quadrilateral result = creator.create(LINE_FOUR_VALUES);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCreateShouldCreateQuadrilateralWhenEightValuesInLine() {
        //when
        Quadrilateral expected = new Quadrilateral(new Point(2, 3), new Point(1, 4),
                new Point(5, 6), new Point(9, 10));
        Quadrilateral result = creator.create(LINE_EIGHT_VALUES);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCreateShouldCreateQuadrilateralWhenNineValuesInLine() {
        //when
        Quadrilateral expected = new Quadrilateral(new Point(2, 1), new Point(5, 5),
                new Point(7, 4), new Point(4, 0), 1.57);
        Quadrilateral result = creator.create(LINE_NINE_VALUES);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCreateShouldCreateQuadrilateralWhenTenValuesInLine() {
        //when
        Quadrilateral expected = new Quadrilateral(new Point(0, 0), new Point(2, 2),
                new Point(4, 0), new Point(2, -2), 1.57, 1.57);
        Quadrilateral result = creator.create(LINE_TEN_VALUES);

        //then
        Assert.assertEquals(expected, result);
    }
}