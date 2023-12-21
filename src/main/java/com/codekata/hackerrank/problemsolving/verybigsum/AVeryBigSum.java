package com.codekata.hackerrank.problemsolving.verybigsum;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class AVeryBigSum {

    // https://www.hackerrank.com/challenges/a-very-big-sum/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int arCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Long> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());
        long result = Result.aVeryBigSum(ar);
        System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();
        bufferedReader.close();
        // bufferedWriter.close();
    }
}

class Result {
    public static long aVeryBigSum(List<Long> ar) {
        long sum = 0L;
        for (Long lo : ar) {
            sum = sum + lo;
        }
        return sum;
    }
}

/*
5
1000000001 1000000002 1000000003 1000000004 1000000005

 */