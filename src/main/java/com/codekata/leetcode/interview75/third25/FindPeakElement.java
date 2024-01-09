package com.codekata.leetcode.interview75.third25;

public class FindPeakElement {

    public static void main(String[] args) {

        //https://leetcode.com/problems/find-peak-element/

        // int[] nums = {1,2,1,3,5,6,4};
        int[] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        final int length = nums.length;
        if (length == 1) {
            return 0;
        }
        if (nums[0] >= nums[1]) {
            return 0;
        }
        if (nums[length - 1] >= nums[length - 2]) {
            return length - 1;
        }
        for (int i = 1; i < length - 1; i++) {
            if(Math.max(nums[i], nums[i-1]) == Math.max(nums[i], nums[i+1])){
            //if (nums[i] >= nums[i - 1] && nums[i] >= nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}
