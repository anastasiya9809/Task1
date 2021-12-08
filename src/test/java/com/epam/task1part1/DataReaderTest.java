package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {
    private static final String PATH = "C:\\Users\\aausi\\Documents\\Task1-Part1\\src\\test\\resources\\input data";
    private static final String INVALID_PATH = "";

    @Test
    public void testReadShouldReadWhenPathValid() throws DataException {
        //given
        DataReader reader = new DataReader();

        //when
        List<String> expected = Arrays.asList(
                "3 5 4 4 5 9 3 9",
                "3 6 9 7 4 9 2 0",
                "1 2 3",
                "abcdefgh");
        List<String> result = reader.read(PATH);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowExceptionWhenPathInvalid() throws DataException {
        //given
        DataReader reader = new DataReader();

        //when
        reader.read(INVALID_PATH);
    }
}