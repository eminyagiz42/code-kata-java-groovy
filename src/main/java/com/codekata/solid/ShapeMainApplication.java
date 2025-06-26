package com.codekata.solid;

import com.codekata.solid.calculator.AreaCalculator;
import com.codekata.solid.calculator.impl.AreaCalculatorImpl;
import com.codekata.solid.printer.ShapePrinter;
import com.codekata.solid.shape.*;

import java.util.List;

public class ShapeMainApplication {

    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculatorImpl();
        List<Shape> shapes = getShapes();
        List<Integer> areas = calculator.calculateArea(shapes);
        ShapePrinter printer = new ShapePrinter();
        System.out.println(printer.toJson(shapes, areas));
    }

    private static List<Shape> getShapes() {
        CircleShape circle = new CircleShape(10);
        SquareShape square = new SquareShape(10);
        RectangleShape rectangle = new RectangleShape(5, 2);
        Cube3D cube = new Cube3D(10);
        NoShape noShape = new NoShape();

        return List.of( circle, square, rectangle, cube /*, noShape */);
    }
}
