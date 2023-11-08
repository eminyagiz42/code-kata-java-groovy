package com.codekata.leetcode;

import java.util.stream.DoubleStream;

/**
 * The type Find max average.
 */
public class FindMaxAverage {

    //https://leetcode.com/problems/maximum-average-subarray-i/

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        //int[] nums = {3,3,4,3,0};
        int k = 4;
        System.out.println(findMaxAverage(nums,k));
    }

    /**
     * Find max average double.
     *
     * @param nums the nums
     * @param k    the k
     * @return the double
     */
    public static double findMaxAverage(int[] nums, int k) {
        int s = 0;
        for (int i = 0; i < k; ++i) {
            s += nums[i];
        }

        int ans = s;
        for (int i = k; i < nums.length; ++i) {
            s += (nums[i] - nums[i - k]);
            ans = Math.max(ans, s);
        }
        return ans * 1.0 / k;
    }

    /**
     * Find max average 1 double.
     *
     * @param nums the nums
     * @param k    the k
     * @return the double
     */
    public static double findMaxAverage1(int[] nums, int k) {
        double total = 0.0;
        int sum = 0;
        if(nums.length == k){
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
        }else if(k == 1) {
            return nums[0];
        } else {
            for (int i = 0; i < k - 1; i++) {
                sum += nums[i];
            }
            total = Math.max(total, sum / (double) k);

            sum = 0;
            for (int i = 1; i < k + 1; i++) {
                sum += nums[i];
            }
            total = Math.max(total, sum / (double) k);

            sum = 0;
            for (int i = 2; i < nums.length; i++) {
                sum += nums[i];
            }
            total = Math.max(total, sum / (double) k);
        }
        return total;
    }

    //This solution finds all the possible combination with k size, and it gives the highest average of array
    private static double dou;

    /**
     * Find max average 2 double.
     *
     * @param nums the nums
     * @param k    the k
     * @return the double
     */
    public static double findMaxAverage2(int[] nums, int k) {
        return printCombination(nums, nums.length, k);
    }

    /**
     * Print combination double.
     *
     * @param arr the arr
     * @param n   the n
     * @param r   the r
     * @return the double
     */
    public static double printCombination(int[] arr, int n, int r) {
        double[] data = new double[r];

        combinationUtil(arr, data, 0, n-1, 0, r);
        return dou;
    }

    /**
     * Combination util.
     *
     * @param arr   the arr
     * @param data  the data
     * @param start the start
     * @param end   the end
     * @param index the index
     * @param k     the k
     */
    public static void combinationUtil(int[] arr, double[] data, int start,
                                       int end, int index, int k) {
        if (index == k) {
            final double maxAverage = DoubleStream.of(data).sum() / (double) k;
            if ( maxAverage > dou ) {
                dou = maxAverage;
            }
            return;
        }

        for (int i=start; i<=end && end-i+1 >= k-index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, k);
        }
    }
}
