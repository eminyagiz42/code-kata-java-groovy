package com.codekata.solid.shape;


public class NoShape implements Shape {

    @Override
    public double area() {
        throw new IllegalStateException("Cannot calculate area");
    }

}
