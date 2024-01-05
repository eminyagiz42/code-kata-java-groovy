package com.codekata.hackerrank.problemsolving.twosets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BetweenTwoSets {

    //https://www.hackerrank.com/challenges/between-two-sets/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);
        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }
        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> brr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }
        int total = Result.getTotalX(arr, brr);
        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        */

        //List<Integer> arr = Arrays.asList(2, 6);
        //List<Integer> brr = Arrays.asList(24, 36); // expected output: 2
        //List<Integer> arr = Arrays.asList(3, 4);
        //List<Integer> brr = Arrays.asList(24, 48); // expected output: 2
        List<Integer> arr = Arrays.asList(2, 4);
        List<Integer> brr = Arrays.asList(16, 32, 96); // expected output: 3
        int total = Result.getTotalX(arr, brr);
        System.out.println(total);
    }
}


class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        List<Integer> rangeNumbers = getAllFactorsInRange(a, b);

        List<Integer> combined = new ArrayList<>(a);
        combined.addAll(b);// combine two lists

        for (int by : combined) { // remove factors if it does not divide evenly
            rangeNumbers.removeIf(range -> Math.max(by, range) % Math.min(by, range) != 0);
        }

        return rangeNumbers.size();
    }

    private static List<Integer> getAllFactorsInRange(List<Integer> a, List<Integer> b) {
        int highest = 0;
        int lowest = Integer.MAX_VALUE;

        for (int num1 : a) {
            highest = Math.max(highest, num1);
        }

        for (int num2 : b) {
            lowest = Math.min(lowest, num2);
        }

        List<Integer> rangeNumbers = new ArrayList<>();
        for (int i = 0; i <= lowest - highest; i++) {
            final int factor = highest + i;
            if (factor % highest == 0) {
                rangeNumbers.add(factor);
            }
        }
        return rangeNumbers;
    }
}



