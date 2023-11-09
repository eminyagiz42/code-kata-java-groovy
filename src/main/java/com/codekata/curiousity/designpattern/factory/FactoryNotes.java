package com.codekata.curiousity.designpattern.factory;

public class FactoryNotes {

    public static void main(String[] args) {
        FoodFactory foodFactory = new FoodFactory();

        Food cake = foodFactory.getFood("cake");
        System.out.println("The factory returned "+ cake.getClass());
        System.out.println(cake.getType());

        Food pizza = foodFactory.getFood("pizza");
        System.out.println("The factory returned "+ pizza.getClass());
        System.out.println(pizza.getType());
    }

}
