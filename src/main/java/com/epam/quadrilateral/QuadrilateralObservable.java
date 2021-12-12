package com.epam.quadrilateral;

import com.epam.quadrilateral.entity.Point;
import com.epam.quadrilateral.entity.Quadrilateral;

import java.util.ArrayList;
import java.util.List;

public class QuadrilateralObservable extends Quadrilateral implements Observable {
    
    private final Integer id;
    private final List<Observer> observers = new ArrayList<>();

    public QuadrilateralObservable(int id, Point pointA, Point pointB, Point pointC, Point pointD) {
        super(pointA, pointB, pointC, pointD);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setPointA(Point pointA) {
        super.setPointA(pointA);
        notifyObservers();
    }

    @Override
    public void setPointB(Point pointB) {
        super.setPointB(pointB);
        notifyObservers();
    }

    @Override
    public void setPointC(Point pointC) {
        super.setPointC(pointC);
        notifyObservers();
    }

    @Override
    public void setPointD(Point pointD) {
        super.setPointD(pointD);
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers){
            observer.update(this);
        }
    }
}
