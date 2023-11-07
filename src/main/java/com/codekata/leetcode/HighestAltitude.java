package com.codekata.leetcode;

public class HighestAltitude {

    public static void main(String[] args) {

        //https://leetcode.com/problems/find-the-highest-altitude/

        int[] gain = {-5,1,5,0,-7};
        System.out.print( largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int sum = 0;
        int largest = 0;
        for (int i = 0; i < gain.length; i++) {
            sum = sum + gain[i];
            if (sum > largest) {
                largest = sum;
            }
        }
        return largest;
    }
}

