package com.codekata.hackerrank.problemsolving.migration;


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MigratoryBirds {

    //https://www.hackerrank.com/challenges/migratory-birds/problem

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int result = Result.migratoryBirds(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
         */
        List<Integer> arr = Arrays.asList(1, 4, 4, 4, 5, 3);  // Expected output: 4
        int result = Result.migratoryBirds(arr);
        System.out.println(result);

    }
}

class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int number : arr) {
            occurrences.put(number, occurrences.getOrDefault(number, 0) + 1);
        }

        int highest = 0;
        for (int occur : occurrences.values()) {
            highest = Math.max(occur, highest);
        }

        int lowest = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> occur : occurrences.entrySet()) {
            if (occur.getValue() == highest) {
                lowest = Math.min(lowest, occur.getKey());
            }
        }

        return lowest;
    }

}


