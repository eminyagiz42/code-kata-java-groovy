package com.codekata.hackerrank.daysofcode.day1;

import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        printResults(i, d, s, scan);

        scan.close();
    }

    private static void printResults(int i, double d, String s, Scanner scan) {
        final int nextInt = scan.nextInt();
        System.out.println((nextInt + i));

        final double nextDouble = scan.nextDouble();
        System.out.println(nextDouble + d);

        while (scan.hasNextLine()) {
            final String nextLine = scan.nextLine();
            if (!"".equals(nextLine)) {
                System.out.println(s.concat(nextLine));
            }
        }
    }
}
