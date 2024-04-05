package com.codekata.hackerrank.problemsolving.triplet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareTriplets {

    //https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=true


    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        List<Integer> result = Result.compareTriplets(a, b);
        bufferedWriter.write(result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n" );
        bufferedReader.close();
        bufferedWriter.close();
         */

        //List<Integer> a = Arrays.asList(17, 28, 30);
        //List<Integer> b = Arrays.asList(99 ,16, 8);
        List<Integer> a = Arrays.asList(5, 6, 7);
        List<Integer> b = Arrays.asList(3 ,6 ,10);
        List<Integer> result = Result.compareTriplets(a, b);
        System.out.println(result);
    }

}


class Result {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int total = 3;
        int draws = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i) ) {
                   total--;
            }
            if (a.get(i).equals(b.get(i))) {
                draws++;
            }
        }

        result.add(3 - total);
        result.add(total - draws);

        return result;
    }

}
