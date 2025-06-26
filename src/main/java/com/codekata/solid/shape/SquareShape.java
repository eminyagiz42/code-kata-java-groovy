package com.codekata.solid.shape;

public class SquareShape implements Shape{

    private final int length;

    public SquareShape(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public double area() {
        return Math.pow(getLength(), 2);
    }
}
