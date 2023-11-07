package com.codekata.practice.program;

import java.util.Scanner;

public class FirstTenPrimeProgram {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me a range for prime number list");
        final int end = scanner.nextInt();
        for (int i = 0; i < end; i++) {
            if (PrimeDetectorProgram.isPrime(i)) {
                System.out.println(i);
            }
        }
        scanner.close();
    }
}
