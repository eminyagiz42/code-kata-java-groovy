package com.codekata.hackerrank.problemsolving.sherlock;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class SherlockSquares {

    //https://www.hackerrank.com/challenges/sherlock-and-squares/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int a = Integer.parseInt(firstMultipleInput[0]);
            int b = Integer.parseInt(firstMultipleInput[1]);
            int result = Result.squares(a, b);
            System.out.println(result);
            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }
        bufferedReader.close();
        // bufferedWriter.close();
        /*
        int a = 24, b = 49; //expected output: 3
        int result = Result.squares(a, b);
        System.out.println(result);
         */
    }
}


class Result {

    /*
     * Complete the 'squares' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     */
    public static int squares(int a, int b) {
        int squareCount = 0;

        int start = (int) Math.ceil(Math.sqrt(a));
        int end = (int) Math.floor(Math.sqrt(b));
        squareCount = end - start + 1;

        return squareCount;
    }

    static List<Integer> arr = Arrays.asList(0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400, 441, 484, 529, 576, 625, 676, 729, 784, 841, 900, 961, 1024, 1089, 1156, 1225, 1296, 1369, 1444, 1521, 1600, 1681, 1764, 1849, 1936, 2025, 2116, 2209, 2304, 2401, 2500, 2601, 2704, 2809, 2916, 3025, 3136, 3249, 3364, 3481, 3600, 3721, 3844, 3969, 4096, 4225, 4356, 4489, 4624, 4761, 4900, 5041, 5184, 5329, 5476, 5625, 5776, 5929, 6084, 6241, 6400, 6561, 6724, 6889, 7056, 7225, 7396, 7569, 7744, 7921, 8100, 8281, 8464, 8649, 8836, 9025, 9216, 9409, 9604, 9801, 10000);

    public static int squaresTwo(int a, int b) { // It exceeds time limit

        int count = 0;
        for (int i = a; i <= b; i++) {
            final int meBinary = findMeBinary(arr, i, 0, arr.size() - 1);
            if (meBinary != -1) {
                count++;
            }
        }

        return count;
    }


    private static int findMeBinary(List<Integer> nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        final int middle = ((int) Math.floor((start + end) / 2));

        if (nums.get(middle) == target) {
            return middle;
        }
        if (nums.get(middle) > target) {
            return findMeBinary(nums, target, start, middle - 1);
        }
        if (nums.get(middle) < target) {
            return findMeBinary(nums, target, middle + 1, end);
        } else {
            return -1;
        }
    }

}
