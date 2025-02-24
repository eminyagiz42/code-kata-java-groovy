package com.codekata.assignment;

import java.util.Arrays;

public class ArrayChallenge {

    public static void main(String[] args) {
        System.out.println(compareLargestAndSum(new int[]{4, 6, 23, 10, 3})); // expected output: true
        System.out.println(compareLargestAndSum(new int[]{5, 7, 16, 1, 2})); // expected output: false
        System.out.println(compareLargestAndSum(new int[]{3, 5, -1, 8, 12})); // expected output: true
    }

    public static String compareLargestAndSum(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sorted().sum();
        return String.valueOf(sum - max - max >= 0);
    }
}
