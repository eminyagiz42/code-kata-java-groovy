package com.codekata.leetcode75.third25;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlapping {

    public static void main(String[] args) {

        // https://leetcode.com/problems/non-overlapping-intervals/

        //int[][] intervals = {{1,2},{1,2},{1,2}}; //output: 2

        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}}; // output: 1

        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int result = 0;
        int currentEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= currentEnd) {
                currentEnd = intervals[i][1];
            } else {
                result++;
            }
        }
        return result;
    }

}
