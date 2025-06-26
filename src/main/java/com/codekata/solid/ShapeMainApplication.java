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
        List<ThreeDimensionalShape> threeDimensionalShapes = get3DShapes();
        List<Integer> areas = calculator.calculateArea(shapes);
        List<Integer> volumes = calculator.calculateVolumes(threeDimensionalShapes);
        ShapePrinter printer = new ShapePrinter();
        System.out.println("Areas : " + printer.toJson(shapes, areas));
        System.out.println("Volumes : " + printer.toJson(threeDimensionalShapes, volumes));
    }

    /* Output:
        Areas : { "Circle": 314, "Square": 100, "Rectangle": 50, "Cube3D": 600}
        Volumes : { "Cube3D": 1000}
     */

    private static List<Shape> getShapes() {
        CircleShape circle = new CircleShape(10);
        SquareShape square = new SquareShape(10);
        RectangleShape rectangle = new RectangleShape(10, 5);
        Cube3D cube = new Cube3D(10);
        NoShape noShape = new NoShape();

        return List.of(circle, square, rectangle, cube /*, noShape */);
    }

    private static List<ThreeDimensionalShape> get3DShapes() {
        Cube3D cube3D = new Cube3D(10);

        return List.of(cube3D);
    }
}
