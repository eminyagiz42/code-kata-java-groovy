package com.codekata.hackerrank.daysofcode.third10.day25;


import java.io.IOException;
import java.util.Scanner;

public class Day25 {

    public static void main(String[] args) throws IOException {
        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
         */

        int[] a = {1,  // Not prime
                4,     // Not prime
                9,     // Not prime
                16,    // Not prime
                25,    // Not prime
                36,    // Not prime
                49,    // Not prime
                64,    // Not prime
                81,    // Not prime
                100,   // Not prime
                121,   // Not prime
                144,   // Not prime
                169,   // Not prime
                196,   // Not prime
                225,   // Not prime
                256,   // Not prime
                289,   // Not prime
                324,   // Not prime
                361,   // Not prime
                400,   // Not prime
                441,   // Not prime
                484,   // Not prime
                529,   // Not prime
                576,   // Not prime
                625,   // Not prime
                676,   // Not prime
                729,   // Not prime
                784,   // Not prime
                841,   // Not prime
                907};  // Prime

        for (int number : a) {
            if (isPrime(number)) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = number / 2; i > 1; i--) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}