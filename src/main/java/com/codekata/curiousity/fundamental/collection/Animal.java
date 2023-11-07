package com.codekata.curiousity.fundamental.collection;

public class Animal {

    /** Encapsulation
     *  Make variables private, and provide getter setters
     *  We don't want this usage -> animal.age = 5;
     *  better way -> animal.setAge(5);
     */
    private int age;
    private String color;

    public Animal() {
    }

    /**
     * "static" and "this" keywords can not be used at the same time.
     * you must choose one of them.
     */
    public Animal(int age, String color) {
        this.age = age;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
