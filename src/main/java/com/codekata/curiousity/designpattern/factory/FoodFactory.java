package com.codekata.curiousity.designpattern.factory;

import com.codekata.curiousity.designpattern.factory.impl.Cake;
import com.codekata.curiousity.designpattern.factory.impl.Pizza;

public class FoodFactory {

    // https://www.hackerrank.com/challenges/java-factory/problem

    public Food getFood(String order) {
        if (order.equals("pizza")) {
            return new Pizza();
        } else if (order.equals("cake")) {
            return new Cake();
        } else {
            return null;
        }
    }
}
