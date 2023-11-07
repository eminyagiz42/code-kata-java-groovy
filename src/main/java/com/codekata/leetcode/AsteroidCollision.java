package com.codekata.leetcode;

import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        //https://leetcode.com/problems/asteroid-collision

        int[] astreoids = {-2,-1,1,2};
        int [] astreoids0 = {5,10,-5};
        int [] astreoids1 = {10,2,-5};
        int [] astreoids2 = {8,-8};
        final int[] ints = asteroidCollision(astreoids);
        for (int num : ints ) {
            System.out.println("num = " + num);
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {//9ms Stack Solution
        Stack<Integer> stack = new Stack<>();
        for (final int a : asteroids)
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                } else if (stack.peek() == -a) {
                    stack.pop();
                }
            }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] asteroidCollision2(int[] asteroids) { //Slow
        if (asteroids[0] < 0 ) {
            int[] reversed = new int[asteroids.length];
            for (int i = 0; i < asteroids.length; i++) {
                reversed[asteroids.length-i-1] = asteroids[i];
            }
            asteroids = reversed;
        }

        int negative = -999;
        for (int i = asteroids.length-1; i >= 0; i--) {
            if (asteroids[i] < 0) {
                negative = asteroids[i];
                if (asteroids[i-1] == Math.abs(asteroids[i])) {
                    asteroids[i] = 0;
                    asteroids[i-1] = 0;
                } else if (asteroids[i-1] > Math.abs(asteroids[i])) {
                    asteroids[i] = 0;
                } else  {
                    asteroids[i-1] = 0;
                }
            }
        }
        if (contains(asteroids, 0)) {
            asteroids = removeZeros(asteroids);
        }

        if(contains(asteroids, negative)){
            asteroidCollision(asteroids);
        }

        if (contains(asteroids, 0)) {
            asteroids = removeZeros(asteroids);
        }
        return asteroids;
    }

    private static int[] removeZeros(int[] arr) {
        int count = 0;
        for (int k : arr) {
            if (k != 0) {
                count++;
            }
        }
        int index = 0;
        int[] newArr = new int[count];
        for (int j : arr) {
            if (j != 0) {
                newArr[index++] = j;
            }
        }
        return newArr;
    }

    private static boolean contains(int[] arr, int key) {
        for (int num : arr) {
            if (num == key) {
                return true;
            }
        }
        return false;
    }
}
