package com.epam.quadrilateral;

import java.util.HashMap;
import java.util.Map;

public class QuadrilateralStore implements Observer {

    private static QuadrilateralStore instance;

    private final Map<Integer, Parameters> parameters = new HashMap<>();

    private final Calculator calculator = new Calculator();

    private QuadrilateralStore(){}

    public Map<Integer, Parameters> getParameters() {
        return parameters;
    }

    public void update(QuadrilateralObservable quadrilateral) {
        double perimeter = calculator.calculatePerimeter(quadrilateral);
        double area = calculator.calculateArea(quadrilateral);

        parameters.put(quadrilateral.getId(), new Parameters(perimeter, area));
    }

    public static QuadrilateralStore getInstance(){
        if (instance == null){
            instance = new QuadrilateralStore();
        }

        return instance;
    }
}
