package com.codekata.leetcode75.third25;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        //https://leetcode.com/problems/longest-common-subsequence

        //String text1 = "abcde", text2 = "ace"; // 3
        //String text1 = "abc", text2 = "abc"; // 3
        //String text1 = "abc", text2 = "def"; // 0
        //String text1 = "ubmrapg", text2 = "ezupkr"; //2
        String text1 = "pmjghexybyrgzczy", text2 = "hafcdqbgncrcbihkd"; // 4

        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        final int lengthOne = text1.length();
        final int lengthTwo = text2.length();
        int[][] result = new int[lengthOne + 1][lengthTwo + 1];

        for (int i = 0; i < lengthOne; ++i) {
            for (int j = 0; j < lengthTwo; ++j) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    result[i + 1][j + 1] = 1 + result[i][j];
                } else {
                    result[i + 1][j + 1] = Math.max(result[i][j + 1], result[i + 1][j]);
                }
            }
        }
        return result[lengthOne][lengthTwo];
    }

        public static int longestCommonSubsequenceNotFinished(String text1, String text2) { // Solved 21 / 47
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        int lastOccurence = 0;
        int count = 0;
        String[] words1 = text1.split("");
        String[] words2 = text2.split("");
        for (String one : words1) {
            for (int j = 0; j < words2.length; j++) {
                if (words2[j].equals(one)) {
                    if (j == 0 || lastOccurence < j) {
                        count++;
                        lastOccurence = j;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
