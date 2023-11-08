package com.codekata.leetcode75.first25;

/**
 * The type Highest altitude.
 */
public class HighestAltitude {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/find-the-highest-altitude/

        int[] gain = {-5,1,5,0,-7};
        System.out.print( largestAltitude(gain));
    }

    /**
     * Largest altitude int.
     *
     * @param gain the gain
     * @return the int
     */
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

