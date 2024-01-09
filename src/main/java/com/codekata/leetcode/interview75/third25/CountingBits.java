package com.codekata.leetcode.interview75.third25;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {
        // https://leetcode.com/problems/counting-bits

        int n = 5;
        System.out.println(Arrays.toString(countBits(n)));
    }

    public static int[] countBits(int n) {
        int[] counting = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            counting[i] = counting[i / 2] + (i % 2);
        }
        return counting;
    }
}
