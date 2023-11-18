package com.codekata.leetcode75.third25;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        //https://leetcode.com/problems/combination-sum-iii

        int k = 3, n = 7;
        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        depthFirstSearch(k, n, 1, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void depthFirstSearch(int k, int n, int s, List<Integer> path, List<List<Integer>> results) {
        if (k == 0 && n == 0) {
            results.add(new ArrayList<>(path));
            return;
        }
        if (k == 0 || n < 0) {
            return;
        }

        for (int i = s; i <= 9; ++i) {
            path.add(i);
            depthFirstSearch(k - 1, n - i, i + 1, path, results);
            path.remove(path.size() - 1);
        }
    }
}
