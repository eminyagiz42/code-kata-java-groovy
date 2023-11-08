package com.codekata.practice;

import com.codekata.util.Constant;

/**
 * The type Reverse string.
 */
public class ReverseString {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println(reverse(Constant.VERY_LONG_SENTENCE));
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("timeElapsed = " + timeElapsed);
    }

    /**
     * Reverse string.
     *
     * @param s the s
     * @return the string
     */
    public static String reverse(String s) { // less than 1ms
        final char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length-1-i];
            charArray[charArray.length-1-i] = temp;
        }

        return  String.valueOf(charArray);
    }

    /**
     * Reverse 1 string.
     *
     * @param s the s
     * @return the string
     */
    public static String reverse1(String s) { // less than 1ms
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    /**
     * Reverse 2 string.
     *
     * @param s the s
     * @return the string
     */
    public static String reverse2(String s) { // 189ms
        char[] letters = new char[s.length()];
        int letterIndex = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            letters[letterIndex] = s.charAt(i);
            letterIndex++;
        }

        String reverse = "";
        for (int i = 0; i < s.length(); i++) {
            reverse = reverse + letters[i];
        }

        return reverse;
    }
}
