package com.codekata.solid.calculator.impl;

import com.codekata.solid.calculator.AreaCalculator;
import com.codekata.solid.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class AreaCalculatorImpl implements AreaCalculator {

    @Override
    public List<Integer> calculateArea(List<Shape> shapes){
        List<Integer> areas = new ArrayList<>();
        for (Shape shape : shapes){
           areas.add((int) shape.area());
        }

        return areas;
    }
}
