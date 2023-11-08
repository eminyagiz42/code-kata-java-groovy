package com.codekata.practice;

/**
 * The type Factorial practice.
 */
public class FactorialPractice {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println(calculateFactorial(5));
    }

    /**
     * Calculate factorial int.
     *
     * @param number the number
     * @return the int
     */
    public static int calculateFactorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * calculateFactorial(number -1);
    }
}
