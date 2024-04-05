package com.codekata.practice;

public class LabStaticProblem {

    public static void main(String[] args) {
        Lab lab = new Lab();
        lab.print1();
        lab.print2();
    }
}


class Lab {

    private static String amount = "";

    void print1() {
        amount = "10.0";
    }

    void print2() {
        System.out.println(amount);
    }

}
