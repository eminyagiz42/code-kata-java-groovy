package com.codekata.javastream;

import java.util.stream.IntStream;

/**
 * The type Combination practice.
 */
public class CombinationPractice {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main (String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int r = 3;
        int n = arr.length;
        printCombination(arr, n, r);
    }

    /**
     * Combination util.
     *
     * @param arr   the arr
     * @param data  the data
     * @param start the start
     * @param end   the end
     * @param index the index
     * @param r     the r
     */
    public static void combinationUtil(int[] arr, int[] data, int start, int end, int index, int r) {
        if (index == r) {
            final int sum = IntStream.of(data).sum() / 4;
            System.out.println(sum);
            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    /**
     * Print combination.
     *
     * @param arr the arr
     * @param n   the n
     * @param r   the r
     */
    public static void printCombination(int[] arr, int n, int r) {
        int[] data = new int[r];

        combinationUtil(arr, data, 0, n-1, 0, r);
    }
}

