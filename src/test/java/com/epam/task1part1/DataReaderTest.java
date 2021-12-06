package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {
    private static final String PATH = "C:\\Users\\aausi\\Documents\\Task1-Part1\\src\\test\\resources\\input data";
    private static final String INVALID_PATH = "sdlfksjdflk";

    @Test
    public void testReadShouldReadWhenPathValid() throws DataException {
        //given
        DataReader reader = new DataReader();

        //when
        List<String> expected = Arrays.asList(
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
        List<String> result = reader.read(PATH);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowExceptionWhenPathInvalid() throws DataException {
        //given
        DataReader reader = new DataReader();

        //when
        List<String> result = reader.read(INVALID_PATH);
    }
}