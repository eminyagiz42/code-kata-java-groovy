package com.codekata.review;

public class MovingZeross {

    public static void main(String[] args) {

        //https://leetcode.com/problems/move-zeroes

        int[] nums = {0, 1, 0, 3, 12};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        moveZerosBySwap(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void moveZerosBySwap(int[] nums) {
        int temp;
        for (int i = nums.length -1; i > 0; i--) {
            if (nums[i] == 0) {
                temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }
}
