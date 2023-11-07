package com.codekata.leetcode.guessnumber;

public abstract class GuessGame {

    public static int guess(int n) {
        int num = 6;
        return Integer.compare(n, num);
    }
}
