package com.codekata.leetcode75.third25;


import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {

    public static void main(String[] args) {

        // https://leetcode.com/problems/maximum-subsequence-score/

        int[] nums1 = {1, 3, 3, 2}, nums2 = {2, 1, 3, 4};
        int k = 3;
        System.out.println(maxScore(nums1, nums2, k)); // Output 12
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        final int length = nums1.length;
        int[][] nums = new int[length][2];
        for (int i = 0; i < length; ++i) {
            nums[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(nums, (a, b) -> b[1] - a[1]);
        long result = 0, s = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < length; ++i) {
            s += nums[i][0];
            priorityQueue.offer(nums[i][0]);
            if (priorityQueue.size() == k) {
                result = Math.max(result, s * nums[i][1]);
                s = s - priorityQueue.poll();
            }
        }
        return result;
    }
}

