package com.codekata.practice.challanges;

import com.codekata.util.Constant;

public class FibonacciChallange {

    public static void main(String[] args) {
        // int[] arr = {5,2,1}; // expected output: 0
        // int[] arr = {1,20,2,5}; // expected output: 6
        //int[] arr = {15,1,3}; // expected output: 2
        int[] arr = {6, 6, 4}; // expected output: 3
        /*int[] arr = {1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5
                ,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20
                ,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,
                1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,
                2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,
                1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,
                2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,
                1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5,1,20,2,5};

         */
        long start = System.currentTimeMillis();
        System.out.println(arrayChallenge(arr));
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("timeElapsed = " + timeElapsed);

    }

    private static int arrayChallenge(int[] arr) {
        int previous = 0;
        int saved = Integer.MAX_VALUE;
        final int sum = sum(arr);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            final int fibonacci = getFibonacci(i);
            if (sum == fibonacci) { // it's a number in fibonacci, no distance
                return 0;
            }
            int distance  = Math.abs(sum - fibonacci); //28 - 34 = -6 but it must be positive value
            saved = Math.min(saved, distance);
            if (previous != 0 && previous < distance) {
                break; // the distance started to increase, so it must stop
            }
            previous = distance; // we need to store the previous distance for comparison
        }
        return previous;
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int num : arr ) {
            sum += num;
        }
        return sum;
    }

    private static int getFibonacci(int nth) {
        if (nth <= 1) {
            return nth;
        }
        return getFibonacci(nth - 1) + getFibonacci(nth - 2);
    }
}
