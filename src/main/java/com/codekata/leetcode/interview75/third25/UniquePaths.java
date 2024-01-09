package com.codekata.leetcode.interview75.third25;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {

        //https://leetcode.com/problems/unique-paths/

        int m = 3, n= 7;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[] paths = new int[n];
        Arrays.fill(paths, 1);
        for (int i = 1; i < m; ++i){
            for (int j = 1; j < n; ++j) {
                paths[j] += paths[j - 1];
            }
        }
        return paths[n - 1];
    }
}
