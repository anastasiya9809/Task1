package com.epam.quadrilateral;

import com.epam.quadrilateral.entity.Point;
import com.epam.quadrilateral.entity.Quadrilateral;
import com.epam.quadrilateral.repository.IdSpecification;
import org.junit.Assert;
import org.junit.Test;

public class IdSpecificationTest {

    private static final Point POINT_A = new Point(5, 6);
    private static final Point POINT_B = new Point(7, -1);
    private static final Point POINT_C = new Point(-3, 1);
    private static final Point POINT_D = new Point(-1, 4);
    private static final IdSpecification SPECIFICATION = new IdSpecification(3);

    @Test
    public void testSpecifiedShouldReturnTrueWhenQuadrilateralIdMatchesGivenId() {
        //given
        QuadrilateralObservable quadrilateral = new QuadrilateralObservable(3, POINT_A, POINT_B, POINT_C, POINT_D);

        //when
        boolean result = SPECIFICATION.specified(quadrilateral);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenQuadrilateralIdDoesNotMatchGivenId() {
        //given
        QuadrilateralObservable quadrilateral = new QuadrilateralObservable(4, POINT_A, POINT_B, POINT_C, POINT_D);

        //when
        boolean result = SPECIFICATION.specified(quadrilateral);

        //then
        Assert.assertFalse(result);
    }
}