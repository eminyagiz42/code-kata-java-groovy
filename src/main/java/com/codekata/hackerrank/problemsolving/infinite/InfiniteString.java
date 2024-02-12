package com.codekata.hackerrank.problemsolving.infinite;


import java.io.*;


public class InfiniteString {

    //https://www.hackerrank.com/challenges/repeated-string/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = bufferedReader.readLine();
        long n = Long.parseLong(bufferedReader.readLine().trim());
        long result = Result.repeatedString(s, n);
        System.out.println(result);
        /*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        */
        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */
    public static long repeatedString(String s, long n) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        long repeatedFullString = count * (n / s.length());

        for (int i = 0; i < (n % s.length()); i++) {
            if (s.charAt(i) == 'a') {
                repeatedFullString++;
            }
        }

        return repeatedFullString;
    }

    public static long repeatedStringSlow(String s, long n) { // Time limit exceeded
        long count = 0;
        for (int i = 0; i < n; i++) {
            final char charAt = s.charAt(i % s.length());
            if (charAt == 'a') {
                count++;
            }
        }

        return count;
    }

}
