package com.codekata.leetcode.interview75.second25;

import java.util.Arrays;

public class FindKthLargest {

    public static void main(String[] args) {

        //https://leetcode.com/problems/kth-largest-element-in-an-array

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] reverseOrder = new int[nums.length];
        for (int num : nums) {
            reverseOrder[--length] = num;
        }
        return reverseOrder[k-1];
    }

    public int findKthLargestSimple(int[] nums, int k) { //simpler version
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
