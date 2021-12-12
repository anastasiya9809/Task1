package com.epam.quadrilateral;

import com.epam.quadrilateral.entity.Point;
import com.epam.quadrilateral.repository.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.mockito.Mockito.when;

public class QuadrilateralRepositoryImplTest {

    private static final QuadrilateralObservable QUADRILATERAL_A = new QuadrilateralObservable(5,
            new Point(5, 3), new Point(7, -1), new Point(4, 3),
            new Point(-1, 4));
    private static final QuadrilateralObservable QUADRILATERAL_B = new QuadrilateralObservable(4,
            new Point(7, 1), new Point(7, -1), new Point(4, 3),
            new Point(-1, 4));
    private static final QuadrilateralObservable QUADRILATERAL_C = new QuadrilateralObservable(6,
            new Point(3, 2), new Point(7, -1), new Point(4, 3),
            new Point(-1, 4));

    @Test
    public void testQueryShouldQueryWhenListElementHasValidID() {
        //given
        QuadrilateralObservable quadrilateralValidId = Mockito.mock(QuadrilateralObservable.class);

        QuadrilateralRepositoryImpl repository = new QuadrilateralRepositoryImpl();
        repository.add(quadrilateralValidId);

        IdSpecification specification = Mockito.mock(IdSpecification.class);
        when(specification.specified(quadrilateralValidId)).thenReturn(true);

        //when
        List<QuadrilateralObservable> expected = Arrays.asList(quadrilateralValidId);
        List<QuadrilateralObservable> result = repository.query(specification);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testQueryShouldQueryWhenListElementHasInvalidID() {
        //given
        QuadrilateralObservable quadrilateralInvalidId = Mockito.mock(QuadrilateralObservable.class);

        QuadrilateralRepositoryImpl repository = new QuadrilateralRepositoryImpl();
        repository.add(quadrilateralInvalidId);

        IdSpecification specification = Mockito.mock(IdSpecification.class);
        when(specification.specified(quadrilateralInvalidId)).thenReturn(false);

        //when
        List<QuadrilateralObservable> result = repository.query(specification);

        //then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testSortShouldSortBasedOnXCoordinateOfFirstPoint() {
        //given
        QuadrilateralRepositoryImpl repository = new QuadrilateralRepositoryImpl();
        repository.add(QUADRILATERAL_A);
        repository.add(QUADRILATERAL_B);
        repository.add(QUADRILATERAL_C);

        Comparator<QuadrilateralObservable> comparator = new XCoordinateFirstPointComparator();

        //when
        List<QuadrilateralObservable> expected = Arrays.asList(QUADRILATERAL_C,
                QUADRILATERAL_A, QUADRILATERAL_B);
        List<QuadrilateralObservable> result = repository.sort(comparator);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSortShouldSortBasedOnYCoordinateOfFirstPoint() {
        //given
        QuadrilateralRepositoryImpl repository = new QuadrilateralRepositoryImpl();
        repository.add(QUADRILATERAL_A);
        repository.add(QUADRILATERAL_B);
        repository.add(QUADRILATERAL_C);

        Comparator<QuadrilateralObservable> comparator = new YCoordinateFirstPointComparator();

        //when
        List<QuadrilateralObservable> expected = Arrays.asList(QUADRILATERAL_B,
                QUADRILATERAL_C, QUADRILATERAL_A);
        List<QuadrilateralObservable> result = repository.sort(comparator);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSortShouldSortBasedOnId() {
        //given
        QuadrilateralRepositoryImpl repository = new QuadrilateralRepositoryImpl();
        repository.add(QUADRILATERAL_A);
        repository.add(QUADRILATERAL_B);
        repository.add(QUADRILATERAL_C);

        Comparator<QuadrilateralObservable> comparator = new IdComparator();

        //when
        List<QuadrilateralObservable> expected = Arrays.asList(QUADRILATERAL_B,
                QUADRILATERAL_A, QUADRILATERAL_C);
        List<QuadrilateralObservable> result = repository.sort(comparator);

        //then
        Assert.assertEquals(expected, result);
    }
}