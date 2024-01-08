package com.codekata.hackerrank.daysofcode.second10.day16;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Day16 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();

        try {
            System.out.println(Integer.parseInt(S));
        } catch (Exception exception) {
            System.out.println("Bad String");
        }

        bufferedReader.close();
    }
}
