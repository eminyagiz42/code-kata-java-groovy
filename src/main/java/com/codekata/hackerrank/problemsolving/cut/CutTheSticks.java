package com.codekata.hackerrank.problemsolving.cut;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CutTheSticks {

    //https://www.hackerrank.com/challenges/cut-the-sticks/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {

        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        List<Integer> result = Result.cutTheSticks(arr);
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );
        bufferedWriter.close();
        bufferedReader.close();
        */
        List<Integer> arr = Arrays.asList(5, 4, 4, 2, 2, 8);
        List<Integer> result = Result.cutTheSticks(arr);
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        List<Integer> exceptThisNumbers = new ArrayList<>();
        result.add(arr.size());
        int count = arr.size();
        while (count != 0) {
            int lowest = findLowest(arr, exceptThisNumbers);
            exceptThisNumbers.add(lowest);
            count = countMin(arr, lowest);
            if (count != 0) {
                result.add(count);
            }
        }
        return result;
    }

    public static int findLowest(List<Integer> arr, List<Integer> integerList) {
        int lowest = Integer.MAX_VALUE;
        for (Integer value : arr) {
            if (!integerList.contains(value)) {
                lowest = Math.min(value, lowest);
            }
        }

        return lowest;
    }

    public static int countMin(List<Integer> arr, int lowest) {
        int count = 0;
        for (Integer integer : arr) {
            if (lowest >= integer) {
                count++;
            }
        }

        return arr.size() - count;
    }
}
