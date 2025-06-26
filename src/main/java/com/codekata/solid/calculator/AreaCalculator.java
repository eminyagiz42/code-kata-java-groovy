package com.codekata.solid.calculator;

import com.codekata.solid.shape.Shape;
import com.codekata.solid.shape.ThreeDimensionalShape;

import java.util.List;

public interface AreaCalculator {

    public List<Integer> calculateArea(List<Shape> shapes);

    public List<Integer> calculateVolumes(List<ThreeDimensionalShape> threeDimensionalList);

}
