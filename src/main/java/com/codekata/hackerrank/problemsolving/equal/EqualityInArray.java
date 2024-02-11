package com.codekata.hackerrank.problemsolving.equal;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EqualityInArray {

    //https://www.hackerrank.com/challenges/equality-in-a-array/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int result = Result.equalizeArray(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
         */

        List<Integer> arr = Arrays.asList(3, 3, 2, 1, 3);
        int result = Result.equalizeArray(arr);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'equalizeArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int equalizeArray(List<Integer> arr) {
        int highest = 0;
        int count = 0;
        for (int value : arr) {
            for (int element : arr) {
                if (value == element) {
                    count++;
                }
            }
            highest = Math.max(highest, count);
            count = 0;
        }

        return arr.size() - highest;
    }
}
