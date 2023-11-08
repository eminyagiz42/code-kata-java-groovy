package com.codekata.leetcode;

/**
 * The type Longest ones.
 */
public class LongestOnes {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/max-consecutive-ones-iii/

        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}; // [3, 3, 4, 1]
        int k = 2;

        // int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}; // [2, 2, 2, 3, 1, 2, 3, 4]
        // int k = 3;
        System.out.println(longestOnes(nums, k));
    }

    /**
     * Longest ones int.
     *
     * @param nums the nums
     * @param k    the k
     * @return the int
     */
    public static int longestOnes(int[] nums, int k) {
        int[] count1And0 = count1And0InArray(nums);
        int savedSum = 0;
        int j = nums[0] == 0 ? 1 : 0;
        for (int i = j; i < count1And0.length; i = i + 2) {
            int sum = count1And0[i] + calculateAround(count1And0, k, i);
            savedSum = Math.max(savedSum, sum);
        }
        return savedSum;
    }

    private static int[] dataCleaning(int[] intArr) {
        int n = 0;
        int index = 0;
        for (int k : intArr) {
            if (k != 0)
                n++;
        }
        int[] newArray = new int[n];
        for (int element : intArr) {
            if (element != 0) {
                newArray[index] = element;
                index++;
            }
        }
        return newArray;
    }

    //TODO fix the bug about calculating around the element
    private static int calculateAround(int[] intArr, int k, int index) { // [3, 3, 4, 1]
        int element = intArr[index]; // 3, 4 ---> 4 & 6
        boolean isLeft = true;
        boolean isRight = true;
        int sum = 0;
        if (index - 1 < 0) {
            isLeft = false;
        } else {
            sum++;
        }
        if (index + 1 > intArr.length) {
            isRight = false;
        } else {
            sum++;
        }
        return sum;
    }

    private static int[] count1And0InArray(int[] nums) {
        int[] longestSubarray = new int[nums.length];
        int index = 0;
        int countZeros = 0;
        int countOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                countOnes++;
                if (i == nums.length - 1) {
                    longestSubarray[index++] = countZeros;
                    longestSubarray[index++] = countOnes;
                } else if (i != 0 && nums[i + 1] == 0) {
                    longestSubarray[index++] = countZeros;
                    countZeros = 0;
                }
            } else if (nums[i] == 0) {
                countZeros++;
                if (i == nums.length - 1) {
                    longestSubarray[index++] = countOnes;
                    longestSubarray[index++] = countZeros;
                } else if (i != 0 && nums[i + 1] == 1) {
                    longestSubarray[index++] = countOnes;
                    countOnes = 0;
                }
            }
        }
        return dataCleaning(longestSubarray);
    }

    /**
     * Longest ones 2 int.
     *
     * @param nums the nums
     * @param k    the k
     * @return the int
     */
    public static int longestOnes2(int[] nums, int k) {
        int left = 0;
        int right;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
        }
        return right - left;
    }
}
