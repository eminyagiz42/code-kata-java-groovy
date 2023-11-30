package com.codekata.leetcode75.third25;


public class SingleNumber {

    public static void main(String[] args) {
        //https://leetcode.com/problems/single-number/

        int[] nums = {4,1,2,1,2}; // 4
        System.out.println(singleNumber(nums));
    }

    // Bit Manipulation
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (final int num : nums){
            single = single ^ num; // Bit XOR operator
        }
        return single;
    }

    public static int singleNumberNotFinished(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
               // System.out.println(nums[i] + ",  " + nums[j]);
                if (nums[i] != nums[j]) {
                    count++;
                    if (count == nums.length - 1) {
                        return nums[i];
                    }
                }
            }
        }
        return 0;
    }



}
