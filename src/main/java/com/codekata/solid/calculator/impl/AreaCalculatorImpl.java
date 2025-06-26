package com.codekata.solid.calculator.impl;

import com.codekata.solid.calculator.AreaCalculator;
import com.codekata.solid.shape.Shape;
import com.codekata.solid.shape.ThreeDimensionalShape;

import java.util.ArrayList;
import java.util.List;

public class AreaCalculatorImpl implements AreaCalculator {

    @Override
    public List<Integer> calculateArea(List<Shape> shapes) {
        List<Integer> areas = new ArrayList<>();
        for (Shape shape : shapes) {
            areas.add((int) shape.area());
        }

        return areas;
    }

    @Override
    public List<Integer> calculateVolumes(List<ThreeDimensionalShape> threeDimensionalList) {
        List<Integer> volumes = new ArrayList<>();
        for (ThreeDimensionalShape shape : threeDimensionalList) {
            volumes.add((int) shape.volume());
        }

        return volumes;
    }
}
