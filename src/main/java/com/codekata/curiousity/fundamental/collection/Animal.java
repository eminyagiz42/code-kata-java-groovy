package com.codekata.curiousity.fundamental.collection;

/**
 * The type Animal.
 */
public class Animal {

    /** Encapsulation
     *  Make variables private, and provide getter setters
     *  We don't want this usage -> animal.age = 5;
     *  better way -> animal.setAge(5);
     */
    private int age;
    private String color;

    /**
     * Instantiates a new Animal.
     */
    public Animal() {
    }

    /**
     * "static" and "this" keywords can not be used at the same time.
     * you must choose one of them.
     *
     * @param age   the age
     * @param color the color
     */
    public Animal(int age, String color) {
        this.age = age;
        this.color = color;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
