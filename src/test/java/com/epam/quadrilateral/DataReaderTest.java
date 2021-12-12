package com.epam.quadrilateral;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {
    private static final String PATH = "C:\\Users\\aausi\\Documents\\Task1-Part1\\src\\test\\resources\\input data";
    private static final String INVALID_PATH = "";
    private static final List<String> LINES = Arrays.asList(
            "3 5 4 4 5 9 3 9",
            "3 6 9 7 4 9 2 0",
            "1 2 3",
            "abcdefgh");

    @Test
    public void testReadShouldReadWhenPathValid() throws DataException {
        //given
        DataReader reader = new DataReader();

        //when
        List<String> result = reader.read(PATH);

        //then
        Assert.assertEquals(LINES, result);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowExceptionWhenPathInvalid() throws DataException {
        //given
        DataReader reader = new DataReader();

        //when
        reader.read(INVALID_PATH);
    }
}