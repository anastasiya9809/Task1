package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class DirectorTest {
    private final static String PATH = "C:\\Users\\aausi\\Documents\\Task1-Part1\\src\\test\\resources\\input data";
    private final static String INVALID_PATH = "sdlfksjdflk";

    @Test
    public void testReadShouldReadWhenPathValid() throws DataException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        List<String> lines = Arrays.asList(
                "3 5 4",
                "k 4 3",
                "3.4 6.5 5.4",
                "2 5k 0",
                "1 3 5",
                "-5 4 4",
                "0 5 3",
                "7.9 6 4.3",
                "0.0 4 5",
                "3 5 y");
        when(reader.read(PATH)).thenReturn(lines);

        CircleValidator validator = Mockito.mock(CircleValidator.class);
        when(validator.isCircle("3 5 4")).thenReturn(true);
        when(validator.isCircle("k 4 3")).thenReturn(false);
        when(validator.isCircle("3.4 6.5 5.4")).thenReturn(true);
        when(validator.isCircle("2 5k 0")).thenReturn(false);
        when(validator.isCircle("1 3 5")).thenReturn(true);
        when(validator.isCircle("-5 4 4")).thenReturn(false);
        when(validator.isCircle("0 5 3")).thenReturn(false);
        when(validator.isCircle("7.9 6 4.3")).thenReturn(true);
        when(validator.isCircle("0.0 4 5")).thenReturn(false);
        when(validator.isCircle("3 5 y")).thenReturn(false);

        CircleCreator creator = Mockito.mock(CircleCreator.class);
        when(creator.create("3 5 4")).thenReturn(new Circle(3,5, 4));
        when(creator.create("3.4 6.5 5.4")).thenReturn(new Circle(3.4, 6.5, 5.4));
        when(creator.create("1 3 5")).thenReturn(new Circle(1,3, 5));
        when(creator.create("7.9 6 4.3")).thenReturn(new Circle(7.9,6, 4.3));

        Director director = new Director(reader, validator, creator);

        //when
        List<Circle> expected = Arrays.asList(
                new Circle(3, 5, 4),
                new Circle(3.4, 6.5, 5.4),
                new Circle(1, 3, 5),
                new Circle(7.9, 6, 4.3));
        List<Circle> result = director.read(PATH);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowExceptionWhenPathInvalid() throws DataException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.read(INVALID_PATH)).thenThrow(DataException.class);

        CircleValidator validator = Mockito.mock(CircleValidator.class);
        CircleCreator creator = Mockito.mock(CircleCreator.class);
        Director director = new Director(reader, validator, creator);

        //when
        List<Circle> result = director.read(INVALID_PATH);
    }
}