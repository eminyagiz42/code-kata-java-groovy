package com.codekata.solid.shape;

public class RectangleShape implements Shape {

    private final int x;
    private final int y;

    public RectangleShape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double area() {
        return x * y;
    }
}
