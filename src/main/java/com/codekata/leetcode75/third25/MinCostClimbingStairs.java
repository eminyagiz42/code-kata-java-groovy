package com.codekata.leetcode75.third25;

public class MinCostClimbingStairs {

    public static void main(String[] args) {

        // https://leetcode.com/problems/min-cost-climbing-stairs

        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};  // 6
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        final int length = cost.length;
        for (int i = 2; i < length; ++i) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[length - 1], cost[length - 2]);
    }
}