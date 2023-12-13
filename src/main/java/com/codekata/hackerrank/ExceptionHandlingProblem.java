package com.codekata.hackerrank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingProblem {

    //https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem

    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // String n = "2147483648",p = "2147483648";
            int n = in.nextInt();
            int p = in.nextInt();
            System.out.println(Math.floorDiv(n, p));
        } catch (InputMismatchException e) {
            System.out.println(e.getClass().getName());
            //System.out.println("java.util.InputMismatchException");
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }

}

