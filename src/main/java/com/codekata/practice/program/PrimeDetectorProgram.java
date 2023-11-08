package com.codekata.practice.program;

import java.util.Scanner;

/**
 * The type Prime detector program.
 */
public class PrimeDetectorProgram {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me a number that you want to know weather it is prime number or not");

        while (scanner.hasNextInt()) {
            if (isPrime(scanner.nextInt())) {
                System.out.println("Yes, it is a Prime number");
            } else {
                System.out.println("No, it is  not");
            }
        }
        scanner.close();
    }

    /**
     * Is prime boolean.
     *
     * @param number the number
     * @return the boolean
     */
    public static boolean isPrime(int number) {
        for (int i = number / 2; i > 1; i--) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
