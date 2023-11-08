package com.codekata.leetcode75.third25.guessnumber;

/**
 * The type Guess number.
 */
public class GuessNumber extends GuessGame {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/guess-number-higher-or-lower

        System.out.println(guessNumber(4));
    }

    /**
     * Forward declaration of guess API.
     *
     * @param n guess num
     * @return foundNumber
     */
    public static int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            final int m = l + (r - l) / 2;
            if (guess(m) <= 0) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
