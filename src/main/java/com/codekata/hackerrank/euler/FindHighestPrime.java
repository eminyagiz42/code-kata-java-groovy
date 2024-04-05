package com.codekata.hackerrank.euler;

import java.util.Scanner;

public class FindHighestPrime {

    //TODO Review Later

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            System.out.println(findHighestPrime(n));
        }
    }

    public static long findHighestPrime(long num) {
        long highest = 2;
        while (num % 2 == 0) {
            num /= 2;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                highest = Math.max(highest, i);
                num /= i;
            }
        }

        if (num > 2) {
            highest = Math.max(highest, num);
        }

        return highest;
    }
}