package com.codekata.leetcode.interview75.third25;

import java.util.Arrays;
import java.util.OptionalInt;

public class MinEatingSpeed {

    public static void main(String[] args) {

        // https://leetcode.com/problems/koko-eating-bananas/

        // int[] piles = {3,6,7,11};
        // int h = 8;

        // int[] piles = {30,11,23,4,20};
        // int h = 5;

        int[] piles = {30,11,23,4,20}; // output 23
        int h = 6;

        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int hour) {
        int start = 1;
        final OptionalInt max = Arrays.stream(piles).max();
        if (max.isPresent()) {
            int end = max.getAsInt();
            while (start < end) {
                int mid = start + (end - start) / 2;
                if ((searchBinary(piles, mid, hour))) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return end;
        }
        return -1;
    }

    public static boolean searchBinary(int[] bananas, int middleValue, int hour) {
        int time = 0;
        for (int b : bananas) {
            if (b % middleValue != 0) {
                time += ((b / middleValue) + 1);
            } else {
                time += (b / middleValue);
            }
        }
        return time <= hour;
    }
}
