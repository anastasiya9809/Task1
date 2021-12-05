package com.epam.task1part1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    @Test
    public void testReadShouldReadWhenPathValid() throws DataException {
        //given
        DataReader reader = new DataReader();
        String path = "C:\\Users\\aausi\\Documents\\Task1-Part1\\src\\test\\resources\\input data";
        List<String> expected = new ArrayList<>(Arrays.asList(
                "3 5 4",
                "k 4 3",
                "3.4 6.5 5.4",
                "2 5k 0",
                "1 3 5",
                "-5 4 4",
                "0 5 3",
                "7.9 6 4.3",
                "0.0 4 5",
                "3 5 y"));

        //when
        List<String> result = reader.read(path);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowExceptionWhenPathInvalid() throws DataException {
        //given
        DataReader reader = new DataReader();
        String path = "sdlfksjdflk";

        //then
        reader.read(path);
    }
}