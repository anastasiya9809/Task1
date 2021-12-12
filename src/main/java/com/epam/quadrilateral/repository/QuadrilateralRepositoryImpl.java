package com.epam.quadrilateral.repository;

import com.epam.quadrilateral.QuadrilateralObservable;

import java.util.*;

public class QuadrilateralRepositoryImpl implements QuadrilateralRepository  {

    private Map<Integer, QuadrilateralObservable> store = new HashMap<>();

    @Override
    public void add(QuadrilateralObservable quadrilateral) {
        Integer id = quadrilateral.getId();
        store.put(id, quadrilateral);
    }

    @Override
    public void delete(QuadrilateralObservable quadrilateral) {
        Integer id = quadrilateral.getId();
        store.remove(id);
    }

    @Override
    public void update(QuadrilateralObservable quadrilateral) {
        Integer id = quadrilateral.getId();
        store.put(id, quadrilateral);
    }

    @Override
    public List<QuadrilateralObservable> query(Specification specification) {
        List<QuadrilateralObservable> quadrilaterals = new ArrayList<>();
        for (QuadrilateralObservable quadrilateral : store.values()) {
            if (specification.specified(quadrilateral)){
                quadrilaterals.add(quadrilateral);
            }
        }
        return quadrilaterals;
    }

    @Override
    public List<QuadrilateralObservable> sort(Comparator<QuadrilateralObservable> comparator) {
        Collection<QuadrilateralObservable> collection = store.values();
        List<QuadrilateralObservable> quadrilaterals = new ArrayList<>(collection);
        quadrilaterals.sort(comparator);
        return quadrilaterals;
    }
}
