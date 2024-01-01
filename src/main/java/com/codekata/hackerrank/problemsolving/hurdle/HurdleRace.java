package com.codekata.hackerrank.problemsolving.hurdle;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HurdleRace {

    //https://www.hackerrank.com/challenges/the-hurdle-race/problem?isFullScreen=true


    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);
        List<Integer> height = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int result = Result.hurdleRace(k, height);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        */
        //int result = Result.hurdleRace(4, Arrays.asList(1, 6, 3, 5, 2));  // expected output: 2
        int result = Result.hurdleRace(4, Arrays.asList(1, 6, 3, 5, 2));  // expected output: 0
        System.out.println(result);
    }

}


class Result {

    /*
     * Complete the 'hurdleRace' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY height
     */
    public static int hurdleRace(int k, List<Integer> height) {
        int highest = 0;
        for (int h : height) {
            highest = Math.max(h, highest);
        }
//        final int dose = k - highest;
//        if (dose < 0 ) {
//            return 0;
//        }
//        return dose;

        // Completely same as above
        return Math.max(highest - k, 0);
    }

}


