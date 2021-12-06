package com.epam.task1part1;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private final DataReader reader;
    private final CircleValidator validator;
    private final CircleCreator creator;

    public Director(DataReader reader, CircleValidator validator, CircleCreator creator) {
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Circle> read(String path) throws DataException {
        List<Circle> circles = new ArrayList<>();
        List<String> lines = reader.read(path);
        for (String line : lines) {
            if (validator.isCircle(line)){
                Circle circle = creator.create(line);
                circles.add(circle);
            }
        }
        return circles;
    }
}
