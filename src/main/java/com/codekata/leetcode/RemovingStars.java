package com.codekata.leetcode;

import com.codekata.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Removing stars.
 */
public class RemovingStars {

    private static final char STAR_SYMBOL = '*';

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        // https://leetcode.com/problems/removing-stars-from-a-string

        String s0 = "u*ensso****x*q";
        String s1 = "erase*****"; // output ""
        String s2 =  "leet**cod*e"; // output "lecoe"
        //output ornyvoivdjlcbebvvooiljtrxqivumuprpervlwxpatylutcbthxpjufriunjuhfqosuqbeeilqzuzmwkwskcgktphwawpisaqmusdafyzcoqgvlhznnsutjdc
        long start = System.currentTimeMillis();
        System.out.println(removeStars(Constant.VERY_LONG_SENTENCE));
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("timeElapsed = " + timeElapsed);
    }

    /**
     * Remove stars string.
     *
     * @param s the s
     * @return the string
     */
    public static String removeStars(String s) { // 2713ms
        final char[] chars = s.toCharArray();
        List<Integer> starIndexes = detectStarIndexes(chars);
        
        final int size = starIndexes.size();
        for (int i = 0; i < size; i++) {
            detectPreviousIndexes(starIndexes, i, 1);
        }

        return keepCharInIndexes(chars, starIndexes);
    }

    private static String keepCharInIndexes(char[] charArray, List<Integer> starIndexes) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (!starIndexes.contains(i)) {
                result.append(charArray[i]);
            }
        }
        return result.toString();
    }

    private static List<Integer> detectStarIndexes(char[] charArray) {
        List<Integer> starIndexes = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == STAR_SYMBOL) {
                starIndexes.add(i);
            }
        }
        return starIndexes;
    }

    private static void detectPreviousIndexes(List<Integer> starIndexes, int i, int j) {
        if (starIndexes.contains(starIndexes.get(i) - j)) {
            detectPreviousIndexes(starIndexes, i, ++j);
        } else {
            starIndexes.add(starIndexes.get(i) - j);
        }
    }

    /**
     * Remove stars fastest string.
     *
     * @param s the s
     * @return the string
     */
    public static String removeStarsFastest(String s) { // 2ms
        StringBuilder sb = new StringBuilder();
        for (final char c : s.toCharArray()) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
