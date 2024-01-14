package com.codekata.hackerrank.problemsolving.beautiful;

import java.io.*;

public class BeautifulDays {

    //https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int i = Integer.parseInt(firstMultipleInput[0]);
        int j = Integer.parseInt(firstMultipleInput[1]);
        int k = Integer.parseInt(firstMultipleInput[2]);
        int result = Result.beautifulDays(i, j, k);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
         */
        int result = Result.beautifulDays(20, 23, 6);
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */
    public static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for (int l = i; l <= j; l++) {
            double total = (l - reverseInteger(l)) / k;
            if (!isDecimal(total)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isDecimal(double number) {
        return number % 1 != 0;
    }

    public static double reverseInteger(int l) {
        String number = String.valueOf(l);
        StringBuilder builder = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            builder.append(number.charAt(i));
        }
        return Double.parseDouble(builder.toString());
    }

}