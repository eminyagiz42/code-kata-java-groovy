package com.codekata.hackerrank.problemsolving.digit;


import java.io.*;


public class FindDigit {

    //https://www.hackerrank.com/challenges/find-digits/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            int result = Result.findDigits(n);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
        */
        int n = 1012; // expected output: 3
        int result = Result.findDigits(n);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    public static int findDigits(int n) {
        final String numberStr = String.valueOf(n);
        int count = 0;
        for (int i = 0; i < numberStr.length(); i++) {
            try {
                if (n % Integer.parseInt(String.valueOf(numberStr.charAt(i))) == 0) {
                    count++;
                }
            } catch (ArithmeticException exception) {

            }
        }
        return count;
    }

}