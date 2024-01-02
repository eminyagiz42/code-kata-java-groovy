package com.codekata.hackerrank.daysofcode.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day5 {

    //https://www.hackerrank.com/challenges/30-loops/problem

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        while (n != 0) {
            final String str = bufferedReader.readLine();
            System.out.println(getOddEvenSeperatedText(str));
            n--;
        }
        bufferedReader.close();
    }

    //Updated version
    private static String getOddEvenSeperatedText(String str) {
        StringBuilder evenBuilder = new StringBuilder();
        StringBuilder oddBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                evenBuilder.append(str.charAt(i));
            } else {
                oddBuilder.append(str.charAt(i));
            }
        }
        evenBuilder.append(" ").append(oddBuilder);
        return evenBuilder.toString();
    }

    /*
    private static String getOddEvenSeperatedText(String str) {
        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        final char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i % 2 == 0) {
                builder.append(charArray[i]);
            } else {
                builder2.append(charArray[i]);
            }
        }
        builder.append(" ").append(builder2);
        return builder.toString();
    }
     */
}









