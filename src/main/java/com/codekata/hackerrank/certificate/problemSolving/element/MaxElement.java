package com.codekata.hackerrank.certificate.problemSolving.element;


import java.io.*;


public class MaxElement {

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int maxSum = Integer.parseInt(bufferedReader.readLine().trim());
        int k = Integer.parseInt(bufferedReader.readLine().trim());
        int result = Result.maxElement(n, maxSum, k);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        */
        //int n = 3, maxSum = 7, k = 1; //expected output: 3  --> 1,2,1
        int n = 4, maxSum = 6, k = 2; //expected output: 2 --> 1,1,2,1
        int result = Result.maxElement(n, maxSum, k);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'maxElement' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER maxSum
     *  3. INTEGER k
     */
    public static int maxElement(int n, int maxSum, int k) { // It is not completed since limited time in certification
        int[] arr = new int[n];

        int index = k;
        for (int i = 0; i < n; i++) {
            arr[i] = index;
            index++;
        }

        for (int j = arr.length - 1; j >= 0; j--) {
            if (isPossible(maxSum, arr)) {
                int highest = 0;
                for (int element : arr) {
                    highest = Math.max(highest, element);
                }
                return highest;
            }
            arr[j] -= k;
        }

        return -1;
    }

    private static boolean isPossible(int maxSum, int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        return sum < maxSum;
    }
}