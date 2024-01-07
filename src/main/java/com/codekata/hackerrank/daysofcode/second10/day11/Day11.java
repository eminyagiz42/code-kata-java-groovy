package com.codekata.hackerrank.daysofcode.second10.day11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Day11 {

    //https://www.hackerrank.com/challenges/30-2d-arrays/problem

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, 6).forEach(i -> {
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
        bufferedReader.close();
         */

        List<List<Integer>> arr = Arrays.asList(
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 0, 0, 0),
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 0, 2, 4, 4, 0),
                Arrays.asList(0, 0, 0, 2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0)); //expected output : 19

        ArrayList<Integer> arrayList = new ArrayList();
        // find all possible the hourglasses
        // calculate the total in each hourglass
        // 1 can be used in sum of hour glasses and compare with possibilities
        //  and save it on arrayList

        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = 0; j < arr.size() - 2; j++) {
                arrayList.add(arr.get(i).get(j)
                        + arr.get(i).get(j + 1)
                        + arr.get(i).get(j + 2)
                        + arr.get(i + 1).get(j + 1)
                        + arr.get(i + 2).get(j)
                        + arr.get(i + 2).get(j + 1)
                        + arr.get(i + 2).get(j + 2));
            }
        }
        //biggest number in the array list
        System.out.println(Collections.max(arrayList));
    }
}
