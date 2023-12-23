package com.codekata.hackerrank.problemsolving.minimax;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MiniMaxSumProblem {

    //https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
            /*
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());
            Result.miniMaxSum(arr);
            bufferedReader.close();
             */

        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        Result.miniMaxSum(arr);
    }
}


class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void miniMaxSum(List<Integer> arr) {
        long highest = 0;
        long lowest = Long.MAX_VALUE;
        long sum = 0;
        for (int j = 1; j < arr.size() + 1; j++) {
            for (int i = 0; i < arr.size(); i++) {
                if (i != arr.size() - j) {
                    sum += Long.valueOf(arr.get(i));
                }
            }
            highest = Math.max(highest, sum);
            lowest = Math.min(lowest, sum);
            sum = 0;
        }

        System.out.print(lowest + " " + highest);
    }
}
