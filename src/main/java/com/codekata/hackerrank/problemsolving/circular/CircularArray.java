package com.codekata.hackerrank.problemsolving.circular;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularArray {

    //https://www.hackerrank.com/challenges/circular-array-rotation/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);
        int q = Integer.parseInt(firstMultipleInput[2]);
        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }
        List<Integer> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int queriesItem = Integer.parseInt(bufferedReader.readLine().trim());
            queries.add(queriesItem);
        }
        List<Integer> result = Result.circularArrayRotation(a, k, queries);
        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));
            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
         */

        List<Integer> a = Arrays.asList(3, 4, 5); // 0, 1,2  --> 2,0,1 -- -> 1,2,0 : (4,5,3)
        int k = 2;
        List<Integer> queries = Arrays.asList(1, 2); // Expected output: 5,3

        /*
        List<Integer> a = Arrays.asList(1,2,3); // 2, 3, 1
        int k = 2;
        List<Integer> queries = Arrays.asList(0, 1, 2);// Expected output: 2,3,1
        */
        List<Integer> result = Result.circularArrayRotation(a, k, queries);
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     *  3. INTEGER_ARRAY queries
     */

    private static int length;

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();
        length = a.size();

        for (Integer query : queries) {
            //final int rotated = (query - (k % a.size()) + a.size()) % a.size();
            final int rotated = mode(query - mode(k) + a.size());
            result.add(a.get(rotated));
        }

        return result;
    }

    public static int mode(int num) {
        return num % length;
    }
}
