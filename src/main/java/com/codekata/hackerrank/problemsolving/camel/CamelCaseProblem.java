package com.codekata.hackerrank.problemsolving.camel;


import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CamelCaseProblem {

    //https://www.hackerrank.com/challenges/camelcase/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = bufferedReader.readLine();
        int result = Result.camelcase(s);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        bufferedReader.close();
        //bufferedWriter.close();
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'camelcase' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    private static final List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

    public static int camelcase(String s) {
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (!alphabet.contains(String.valueOf(s.charAt(i)))) {
                count++;
            }
        }
        return count;
    }
}
