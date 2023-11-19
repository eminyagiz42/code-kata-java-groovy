package com.codekata.leetcode75.third25;

import java.util.Arrays;

public class NthTribonacci {

    public static void main(String[] args) {
        //https://leetcode.com/problems/n-th-tribonacci-number/

        int n = 25; // expected output 1389537
        System.out.println(tribonacci(n));
    }

    private static final int[] array = {0, 1, 1};

    public static int tribonacci(int n) {
        if (n >= 4) {
            int index = 0;
            for (int i = 3; i < n; i++) {
                array[index++ % 3] = Arrays.stream(array).sum();
            }
        } else if (n == 3) {
            return Arrays.stream(array).sum();
        } else {
            return array[n];
        }
        return Arrays.stream(array).sum();
    }
}

/*
[0, 1, 1]
[2, 1, 1]
[2, 4, 1]
[2, 4, 7]
[13, 4, 7]
[13, 24, 7]
[13, 24, 44]
[81, 24, 44]
[81, 149, 44]
[81, 149, 274]
[504, 149, 274]
[504, 927, 274]
[504, 927, 1705]
[3136, 927, 1705]
[3136, 5768, 1705]
[3136, 5768, 10609]
[19513, 5768, 10609]
[19513, 35890, 10609]
[19513, 35890, 66012]
[121415, 35890, 66012]
[121415, 223317, 66012]
[121415, 223317, 410744]
[755476, 223317, 410744]
[755476, 1389537, 410744]
1389537
 */
