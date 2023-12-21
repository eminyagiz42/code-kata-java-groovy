package com.codekata.hackerrank.java;

import java.util.Scanner;

public class SingletonProblem {

    //https://www.hackerrank.com/challenges/java-singleton/problem

    public static final Scanner in = new Scanner(System.in);
    public String str = "Hello I am a singleton! Let me say %s to you";

    private static SingletonProblem instance;

    private SingletonProblem() {
    }

    public static SingletonProblem getSingleInstance(){
        if(instance == null){
            instance = new SingletonProblem();
        }
        return instance;
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            final String line = s.nextLine();
            final SingletonProblem singleInstance = getSingleInstance();
            System.out.printf((singleInstance.str) + "%n", line);
        }
    }
}
