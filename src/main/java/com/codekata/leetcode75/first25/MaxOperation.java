package com.codekata.leetcode75.first25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Max operation.
 */
public class MaxOperation {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/max-number-of-k-sum-pairs

        //int[] nums = {3,1,3,4,3};
        //int k = 6;

        //int[] nums = {1,2,3,4};
        //int k = 5;

        int[] nums = {63,10,28,31,90,53,75,77,72,47,45,6,49,13,77,61,68,43,33,1,14,62,55,55,38,54,8,79,89,14,50,68,85,12,42,57,4,67,75,6,71,8,61,26,11,20,22,3,70,52,82,70,67,18,66,79,84,51,78,23,19,84,46,61,63,73,80,61,15,12,58,3,21,66,42,55,7,58,85,60,23,69,41,61,35,64,58,84,61,77,45,14,1,38,4,8,42,16,79,60,80,39,67,10,24,15,6,37,68,76,30,53,63,87,11,71,86,82,77,76,37,21,85,7,75,83,80,8,19,25,11,10,41,66,70,14,23,74,33,76,35,89,68,85,83,57,6,72,34,21,57,72,79,29,65,3,67,8,24,24,18,26,27,68,78,64,57,55,68,28,9,11,38,45,61,37,81,89,38,43,45,26,84,62,22,37,51,15,30,67,75,24,66,40,81,74,48,43,78,14,33,19,73,5,1,2,53,29,49,73,23,5};
        int k = 59;
        System.out.print(maxOperations(nums, k));
    }

    /**
     * Max operations int.
     *
     * @param nums the nums
     * @param k    the k
     * @return the int
     */
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] > k)
                end--;
            else if (nums[start] + nums[end] < k)
                start++;
            else {
                start++;
                end--;
                result++;
            }
        }
        return result;
    }


    /**
     * Max operations 2 int.
     *
     * @param nums the nums
     * @param k    the k
     * @return the int
     */
// TODO 18 / 51 testcases passed
    public static int maxOperations2(int[] nums, int k) { // current output: 57, expected output: 42
        List<Integer> collection = new ArrayList<>();
        int counter = 0;
        int firstIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!collection.contains(i)) {
                firstIndex = i;
                int remained = k - nums[firstIndex];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == remained) {
                        collection.add(firstIndex);
                        collection.add(j);
                        //nums = removeElement(nums, i, j);
                        counter++;
                        break;
                    }
                }
            }
        }
        return counter;
    }

    /**
     * Remove element int [ ].
     *
     * @param nums        the nums
     * @param firstIndex  the first index
     * @param secondIndex the second index
     * @return the int [ ]
     */
    public static int[] removeElement(int[] nums, int firstIndex, int secondIndex) { // Use it by iterator.
        int[] newArr = new int[nums.length - 2];
        int newIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != firstIndex && i != secondIndex) {
                newArr[newIndex] = nums[i];
                newIndex++;
            }
        }
        return newArr;
    }
}

