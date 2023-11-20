package com.codekata.leetcode75.third25;

public class HouseRobber {

    public static void main(String[] args) {

        //https://leetcode.com/problems/house-robber

        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) { //O(n) time complexity
        int prev1 = 0; // dp[i - 1]
        int prev2 = 0; // dp[i - 2]

        for (final int num : nums) {
            final int dp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = dp;
        }
        return prev1;
    }
}
