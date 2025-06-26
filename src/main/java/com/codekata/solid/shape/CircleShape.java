package com.codekata.solid.shape;

public class CircleShape implements Shape{

    private final int radius;

    public CircleShape(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(getRadius(), 2);
    }
}
