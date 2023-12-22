package com.codekata.hackerrank.problemsolving.plusminus;


import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class PlusMinusProblem {

    //https://www.hackerrank.com/challenges/plus-minus/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        double positives = 0.0;
        double negatives = 0.0;
        double zeros = 0.0;
        for (Integer num : arr) {
            if (num == 0) {
                zeros++;
            } else if (num > 0) {
                positives++;
            } else {
                negatives++;
            }
        }

        System.out.println(positives / ((double) arr.size()));
        System.out.println(negatives / ((double) arr.size()));
        System.out.println(zeros / ((double) arr.size()));
    }

}

/*
6
-4 3 -9 0 4 1

0.5
0.3333333333333333
0.16666666666666666
 */