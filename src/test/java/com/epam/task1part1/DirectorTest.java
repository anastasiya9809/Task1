package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class DirectorTest {
    private final static String PATH = "C:\\Users\\aausi\\Documents\\Task1-Part1\\src\\test\\resources\\input data";
    private final static String INVALID_PATH = "";

    @Test
    public void testReadShouldReadWhenPathValid() throws DataException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        List<String> lines = Arrays.asList(
                "3 3 0.20 0.08",
                "3 5 4 4 5 9 3 9",
                "3 5 4 4 5 9 3 9 7",
                "3 5 4 4 5 9 3 9 3 2",
                "1 2 3",
                "abcdefgh");
        when(reader.read(PATH)).thenReturn(lines);

        QuadrilateralValidator validator = Mockito.mock(QuadrilateralValidator.class);
        when(validator.isQuadrilateral("3 3 0.20 0.08")).thenReturn(true);
        when(validator.isQuadrilateral("3 5 4 4 5 9 3 9")).thenReturn(true);
        when(validator.isQuadrilateral("3 5 4 4 5 9 3 9 7")).thenReturn(true);
        when(validator.isQuadrilateral("3 5 4 4 5 9 3 9 3 2")).thenReturn(true);
        when(validator.isQuadrilateral("1 2 3")).thenReturn(false);
        when(validator.isQuadrilateral("abcdefgh")).thenReturn(false);

        QuadrilateralCreator creator = Mockito.mock(QuadrilateralCreator.class);
        when(creator.create("3 3 0.20 0.08")).thenReturn(new Quadrilateral(3, 3, 0.20, 0.08));
        when(creator.create("3 5 4 4 5 9 3 9")).thenReturn(new Quadrilateral(new Point(3, 5), new Point(4, 4), new Point(5, 9),
                new Point(3, 9)));
        when(creator.create("3 5 4 4 5 9 3 9 7")).thenReturn(new Quadrilateral(new Point(3, 5), new Point(4, 4), new Point(5, 9),
                new Point(3, 9), 7));
        when(creator.create("3 5 4 4 5 9 3 9 3 2")).thenReturn(new Quadrilateral(new Point(3, 5), new Point(4, 4), new Point(5, 9),
                new Point(3, 9), 3, 2));

        Director director = new Director(reader, validator, creator);

        //when
        List<Quadrilateral> expected = Arrays.asList(
                new Quadrilateral(3, 3, 0.20, 0.08),
                new Quadrilateral(new Point(3, 5), new Point(4, 4), new Point(5, 9),
                new Point(3, 9)),
                new Quadrilateral(new Point(3, 5), new Point(4, 4), new Point(5, 9),
                new Point(3, 9), 7),
                new Quadrilateral(new Point(3, 5), new Point(4, 4), new Point(5, 9),
                new Point(3, 9), 3, 2));
        List<Quadrilateral> result = director.read(PATH);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowExceptionWhenPathInvalid() throws DataException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.read(INVALID_PATH)).thenThrow(DataException.class);

        QuadrilateralValidator validator = Mockito.mock(QuadrilateralValidator.class);
        QuadrilateralCreator creator = Mockito.mock(QuadrilateralCreator.class);
        Director director = new Director(reader, validator, creator);

        //when
        director.read(INVALID_PATH);
    }
}