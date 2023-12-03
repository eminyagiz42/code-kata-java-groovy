package com.codekata.leetcode75.third25;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {

    public static void main(String[] args) {

        // https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

        int[][] intervals = {{10,16},{2,8},{1,6},{7,12}}; // output: 2

        System.out.println(findMinArrowShots(intervals));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int counter = 1;
        int arrowLocation = points[0][1];

        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] > arrowLocation) {
                arrowLocation = points[i][1];
                ++counter;
            }
        }
        return counter;
    }
}
