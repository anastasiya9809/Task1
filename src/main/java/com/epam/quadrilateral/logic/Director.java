package com.epam.quadrilateral.logic;

import com.epam.quadrilateral.exception.DataException;
import com.epam.quadrilateral.entity.Quadrilateral;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private final DataReader reader;
    private final QuadrilateralValidator validator;
    private final QuadrilateralCreator creator;

    public Director(DataReader reader, QuadrilateralValidator validator, QuadrilateralCreator creator) {
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Quadrilateral> read(String path) throws DataException {
        List<Quadrilateral> quadrilaterals = new ArrayList<>();
        List<String> lines = reader.read(path);
        for (String line : lines) {
            if (validator.isQuadrilateral(line)){
                Quadrilateral quadrilateral = creator.create(line);
                quadrilaterals.add(quadrilateral);
            }
        }
        return quadrilaterals;
    }
}
