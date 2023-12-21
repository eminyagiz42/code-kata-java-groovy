package com.codekata.hackerrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CovarianceProblem {

    //https://www.hackerrank.com/challenges/java-covariance/problem

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        switch (s) {
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndhraPradesh":
                region = new AndhraPradesh();
                break;
        }
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());

    }
}


abstract class Flower {
    abstract String whatsYourName();
}

class Jasmine extends Flower {
    @Override
    String whatsYourName() {
        return "Jasmine";
    }
}

class Lily extends Flower {

    @Override
    String whatsYourName() {
        return "Lily";
    }
}

abstract class Region {
    public abstract Flower yourNationalFlower();
}

class WestBengal extends Region {
    @Override
    public Flower yourNationalFlower() {
        return new Jasmine();
    }
}

class AndhraPradesh extends Region {
    @Override
    public Flower yourNationalFlower() {
        return new Lily();
    }
}
