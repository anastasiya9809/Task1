package com.epam.quadrilateral;

import com.epam.quadrilateral.entity.Quadrilateral;
import com.epam.quadrilateral.exception.DataException;
import com.epam.quadrilateral.logic.DataReader;
import com.epam.quadrilateral.logic.Director;
import com.epam.quadrilateral.logic.QuadrilateralCreator;
import com.epam.quadrilateral.logic.QuadrilateralValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class DirectorTest {
    private final static String PATH_TO_VALID_LINE = "C:\\Users\\aausi\\Documents\\Task1-Part1\\src\\test\\resources\\input data 2";
    private final static String PATH_TO_INVALID_LINE = "C:\\Users\\aausi\\Documents\\Task1-Part1\\src\\test\\resources\\input data 3";
    private final static String VALID_LINE = "3 5 4 4 5 9 3 9";
    private final static String INVALID_LINE = "abcdefgh";
    private final static Quadrilateral QUADRILATERAL = Mockito.mock(Quadrilateral.class);

    @Test
    public void testReadShouldCreateWhenValid() throws DataException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.read(PATH_TO_VALID_LINE)).thenReturn(Arrays.asList(VALID_LINE));

        QuadrilateralValidator validator = Mockito.mock(QuadrilateralValidator.class);
        when(validator.isQuadrilateral(VALID_LINE)).thenReturn(true);

        QuadrilateralCreator creator = Mockito.mock(QuadrilateralCreator.class);
        when(creator.create(VALID_LINE)).thenReturn(QUADRILATERAL);

        Director director = new Director(reader, validator, creator);

        //when
        List<Quadrilateral> expected = Arrays.asList(QUADRILATERAL);
        List<Quadrilateral> result = director.read(PATH_TO_VALID_LINE);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testReadShouldNotCreateWhenInvalid() throws DataException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.read(PATH_TO_INVALID_LINE)).thenReturn(Arrays.asList(INVALID_LINE));

        QuadrilateralValidator validator = Mockito.mock(QuadrilateralValidator.class);
        when(validator.isQuadrilateral(INVALID_LINE)).thenReturn(false);

        QuadrilateralCreator creator = Mockito.mock(QuadrilateralCreator.class);

        Director director = new Director(reader, validator, creator);

        //when
        List<Quadrilateral> result = director.read(PATH_TO_INVALID_LINE);

        //then
        Assert.assertTrue(result.isEmpty());
    }
}