package com.codekata.hackerrank.daysofcode.days10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Days10 {

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(bufferedReader.readLine().trim());
        //bufferedReader.close();

        //int n = 125; // expected output: 5
        final int n = (int) (Math.pow(10, 6) - 1); // expected output: 6
        final String binaryString = Integer.toBinaryString(n); //11110100001000111111

        int highest = 0, count = 0;
        for (char c : binaryString.toCharArray()) {
            if (c == '0') {
                highest = Math.max(highest, count);
                count = 0;
            } else {
                count++;
            }

            if (c == binaryString.charAt(binaryString.length() - 1)) {
                highest = Math.max(highest, count);
            }
        }

        System.out.println(highest);

    }
}

