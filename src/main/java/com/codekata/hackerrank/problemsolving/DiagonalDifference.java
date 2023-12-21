package com.codekata.hackerrank.problemsolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DiagonalDifference {

    //https://www.hackerrank.com/challenges/diagonal-difference/problem

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);
        System.out.println(result);
        //  bufferedWriter.write(String.valueOf(result));
        //  bufferedWriter.newLine();
        bufferedReader.close();
        // bufferedWriter.close();
    }
}

class Result {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int index = 0;
        int index2nd = arr.size() - 1;
        int sum = 0;
        for (List<Integer> number : arr) {
            sum += number.get(index++) - number.get(index2nd--);
        }
        return Math.abs(sum);
    }
}

/*
3
11 2 4
4 5 6
10 8 -12

 */