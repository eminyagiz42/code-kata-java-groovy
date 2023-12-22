package com.codekata.hackerrank.problemsolving.staircase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StaircaseProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        Result.staircase(n);
        bufferedReader.close();

        //Result.staircase(6);
    }
}


class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i + 1; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}

/*
expected output:
     #
    ##
   ###
  ####
 #####
######
 */
