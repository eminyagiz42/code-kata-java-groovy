package com.codekata.leetcode75.third25;

public class NumTilings {

    public static void main(String[] args) {
        //https://leetcode.com/problems/domino-and-tromino-tiling
        System.out.println(numTilings(5));
    }

    public static int numTilings(int n) {
        final int kMod = 1_000_000_007;
        long[] results = new long[1001];
        results[1] = 1;
        results[2] = 2;
        results[3] = 5;

        for (int i = 4; i <= n; ++i) {
            results[i] = (2 * results[i - 1] + results[i - 3]) % kMod;
        }
        return (int) results[n];
    }
}
