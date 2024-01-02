package com.codekata.hackerrank.problemsolving.day;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DayOfProgrammer {

    //https://www.hackerrank.com/challenges/day-of-the-programmer/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int year = Integer.parseInt(bufferedReader.readLine().trim());
        String result = Result.dayOfProgrammer(year);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        //int year = 2017; // 13.09.2017
        //int year = 1918; // 26.09.1918
        //String result = Result.dayOfProgrammer(year);
        //System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */
    public static String dayOfProgrammer(int year) { // Updated Version
        if (year == 1918) {
            return "26.09." + year;
        }

        if ((year < 1918 && year % 4 == 0) || (year > 1918 && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)))) {
            return "12.09." + year;
        }

        return "13.09." + year;
    }

    public static String dayOfProgrammer1(int year) { //Version 1
        if (year == 1918) {
            return "26.09.".concat(String.valueOf(year));
        } else if (year < 1918) {
            if (year % 4 == 0) {
                return "12.09.".concat(String.valueOf(year));
            }
            return "13.09.".concat(String.valueOf(year));
        } else if (year > 1918 && year % 400 == 0) {
            return "12.09.".concat(String.valueOf(year));
        } else if (year % 4 == 0 && year % 100 != 0) {
            return "12.09.".concat(String.valueOf(year));
        }

        return "13.09.".concat(String.valueOf(year));
    }

    public static String dayOfProgrammer2(int year) { //Version 2
        if (year == 1918) {
            return "26.09.".concat(String.valueOf(year));
        } else if (year < 1918) {
            if (year % 4 == 0) {
                return "12.09.".concat(String.valueOf(year));
            }
            return "13.09.".concat(String.valueOf(year));
        } else {
            if (year % 400 == 0) {
                return "12.09.".concat(String.valueOf(year));
            } else if (year % 4 == 0 && year % 100 != 0) {
                return "12.09.".concat(String.valueOf(year));
            }
            return "13.09.".concat(String.valueOf(year));
        }
    }
}
