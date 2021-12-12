package com.epam.quadrilateral.repository;

import com.epam.quadrilateral.QuadrilateralObservable;
import com.epam.quadrilateral.entity.Quadrilateral;

import java.util.Comparator;
import java.util.List;

public interface QuadrilateralRepository {
    void add(QuadrilateralObservable quadrilateral);
    void delete(QuadrilateralObservable quadrilateral);
    void update(QuadrilateralObservable quadrilateral);
    List<QuadrilateralObservable> query(Specification specification);
    List<QuadrilateralObservable> sort(Comparator<QuadrilateralObservable> comparator);
}
