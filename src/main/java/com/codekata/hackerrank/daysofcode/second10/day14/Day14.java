package com.codekata.hackerrank.daysofcode.second10.day14;

import java.util.Scanner;


public class Day14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}


class Difference {

    private int[] elements;
    public int maximumDifference;

    public Difference(int[] a) {
        elements = a;
    }

    public void computeDifference() {
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length - 1; j++) {
                if (j != i) {
                    maximumDifference = Math.max(Math.abs(elements[i] - elements[j]), maximumDifference);
                }
            }
        }
    }

}

