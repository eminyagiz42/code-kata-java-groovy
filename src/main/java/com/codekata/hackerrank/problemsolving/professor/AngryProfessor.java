package com.codekata.hackerrank.problemsolving.professor;


import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class AngryProfessor {

//https://www.hackerrank.com/challenges/angry-professor/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                int n = Integer.parseInt(firstMultipleInput[0]);
                int k = Integer.parseInt(firstMultipleInput[1]);
                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                String result = Result.angryProfessor(k, a);
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        bufferedWriter.close();
         */

        int k = 3;
        List<Integer> a = Arrays.asList(-1, -3, 4, 2);
        String result = Result.angryProfessor(k, a);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'angryProfessor' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY a
     */
    public static String angryProfessor(int k, List<Integer> a) {
        int count = 0;
        for (int arrival : a) {
            if (arrival <= 0) {
                count++;
            }
            if (count >= k) {
                return "NO";
            }
        }

        return "YES";
    }

}