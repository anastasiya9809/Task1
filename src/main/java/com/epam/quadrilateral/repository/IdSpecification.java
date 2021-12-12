package com.epam.quadrilateral.repository;

import com.epam.quadrilateral.QuadrilateralObservable;

public class IdSpecification implements Specification {

    private final Integer id;

    public IdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(QuadrilateralObservable quadrilateral) {
        Integer otherId = quadrilateral.getId();
        return otherId.equals(id);
    }
}
