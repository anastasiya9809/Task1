package com.epam.quadrilateral.repository;

import com.epam.quadrilateral.QuadrilateralObservable;
import com.epam.quadrilateral.entity.Quadrilateral;

public interface Specification {

    boolean specified(QuadrilateralObservable quadrilateral);

}
