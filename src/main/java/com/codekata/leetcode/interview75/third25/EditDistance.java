package com.codekata.leetcode.interview75.third25;

public class EditDistance {

    public static void main(String[] args) {

        //https://leetcode.com/problems/edit-distance/

        String word1 = "horse", word2 = "ros"; // expected output : 3

        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        final int lengthFirst = word1.length();
        final int lengthSecond = word2.length();

        int[][] results = new int[lengthFirst + 1][lengthSecond + 1];

        for (int i = 1; i <= lengthFirst; ++i) {
            results[i][0] = i;
        }

        for (int j = 1; j <= lengthSecond; ++j) {
            results[0][j] = j;
        }

        for (int i = 1; i <= lengthFirst; ++i) {
            for (int j = 1; j <= lengthSecond; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    results[i][j] = results[i - 1][j - 1];
                } else {
                    results[i][j] = Math.min(results[i - 1][j - 1], Math.min(results[i - 1][j], results[i][j - 1])) + 1;
                }
            }
        }
        return results[lengthFirst][lengthSecond];
    }
}
