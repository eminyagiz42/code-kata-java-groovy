package com.codekata.leetcode.interview75.third25;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

    public static void main(String[] args) {

        // https://leetcode.com/problems/daily-temperatures/

        int[] temperatures = {73,74,75,71,69,72,76,73}; // output: {1,1,4,2,1,1,0,0};

        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; ++i) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                final int index = stack.pop();
                results[index] = i - index;
            }
            stack.push(i);
        }
        return results;
    }
}

