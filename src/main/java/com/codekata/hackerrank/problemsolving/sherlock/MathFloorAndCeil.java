package com.codekata.hackerrank.problemsolving.sherlock;

public class MathFloorAndCeil {

    public static void main(String[] args) {

        final double sqrt = Math.sqrt(121);

        System.out.println(Math.ceil(sqrt)); //11.0
        System.out.println(Math.floor(sqrt)); //11.0

        final double sqrt2 = Math.sqrt(120);

        System.out.println(Math.ceil(sqrt2)); //11.0
        System.out.println(Math.floor(sqrt2)); //10.0
    }
}
