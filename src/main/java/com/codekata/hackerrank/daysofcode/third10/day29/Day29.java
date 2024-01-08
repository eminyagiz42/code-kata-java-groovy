package com.codekata.hackerrank.daysofcode.third10.day29;

import java.io.*;
import java.util.stream.IntStream;


public class Day29 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                int count = Integer.parseInt(firstMultipleInput[0]);
                int lim = Integer.parseInt(firstMultipleInput[1]);
                int res = Result.bitwiseAnd(count, lim);
                bufferedWriter.write(String.valueOf(res));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        bufferedWriter.close();

        /*
        int count = 3, lim = 5;
        int res = Result.bitwiseAnd(count, lim);
        System.out.println(res);
         */
    }
}

class Result {

    /*
     * Complete the 'bitwiseAnd' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. INTEGER K
     */
    public static int bitwiseAnd(int n, int k) {
        int max = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int andBitResult = j & i;
                if (andBitResult > max && andBitResult < k) {
                    max = andBitResult;
                }
            }
        }
        return max;
    }
}

