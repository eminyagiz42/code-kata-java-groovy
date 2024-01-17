package com.codekata.hackerrank.problemsolving.prisoner;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class SaveThePrisoner {
    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                int n = Integer.parseInt(firstMultipleInput[0]);
                int m = Integer.parseInt(firstMultipleInput[1]);
                int s = Integer.parseInt(firstMultipleInput[2]);
                int result = Result.saveThePrisoner(n, m, s);
                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        bufferedWriter.close();
        */

        //int n = 4, m = 6, s = 2; // expected output: 3
        //int n = 7 , m = 19, s = 2; // expected output: 6
        //int n = 3, m = 7, s = 3; // expected output: 3
        //int n = 5, m = 2, s = 1; // expected output: 2
        //int n = 5, m = 2, s = 2; // expected output: 3
        //int n = 526663404, m =   801992888, s = 526663403; // expected output: 275329482
        int n = 436776012, m =  436776012, s = 436776011; // expected output: 436776010
        int result = Result.saveThePrisoner(n, m, s);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'saveThePrisoner' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER s
     */
    public static int saveThePrisoner(int n, int m, int s) {
        int start = s - 1;
        int end = m + start;
        /*
        for (int i = start; i < end; i++) {
            if (i == (end - 1)) {
                return (i % n) + 1;
            }
        }
         */
        // We only need last index in loop: "end - 1"
        return ((end - 1) % n) + 1;
    }

}