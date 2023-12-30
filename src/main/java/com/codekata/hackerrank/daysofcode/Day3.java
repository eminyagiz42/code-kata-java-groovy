package com.codekata.hackerrank.daysofcode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Day3 {

    /*
    If  is odd, print Weird
    If  is even and in the inclusive range of 2 to 5, print Not Weird
    If  is even and in the inclusive range of 6 to 20, print Weird
    If  is even and greater than 20, print Not Weird
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(bufferedReader.readLine().trim());

            if (N % 2 == 1) {
                System.out.println("Weird");
            } else if (N >= 2 && N <= 5) {
                System.out.println("Not Weird");
            } else if (N >= 6 && N <= 20) {
                System.out.println("Weird");
            } else if (N > 20) {
                System.out.println("Not Weird");
            }
        }
    }

}

