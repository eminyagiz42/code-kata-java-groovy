package com.codekata.hackerrank.daysofcode.first10.day7;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Day7 {

    //https://www.hackerrank.com/challenges/30-arrays/problem

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }
        bufferedReader.close();
                 */

        List<Integer> arr = Arrays.asList(1, 4, 3, 2); // expected output: 2 3 4 1

        Collections.reverse(arr);

        for (int number : arr) {
            System.out.print(number + " ");
        }

    }
}

