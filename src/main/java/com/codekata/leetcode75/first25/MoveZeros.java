package com.codekata.leetcode75.first25;

/**
 * The type Move zeros.
 */
public class MoveZeros {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/move-zeroes

        /* expected algorithm steps
                nums[0] = nums[1];
                nums[1] = 0;

                nums[1] = nums[3];
                nums[3] = 0;

                nums[2] = nums[4];
                nums[4] = 0;
        */

        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * Move zeroes.
     *
     * @param nums the nums
     */
    public static void moveZeroes(int[] nums) {
        int countZeros = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeros++;
            }
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = nums.length - countZeros; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

