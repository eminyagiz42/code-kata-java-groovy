package com.codekata.hackerrank.problemsolving.county;


import java.io.*;

public class CountyValleys {

    //https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int steps = Integer.parseInt(bufferedReader.readLine().trim());
        String path = bufferedReader.readLine();
        int result = Result.countingValleys(steps, path);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        */
        //int steps = 8; // expected output: 1
        //String path = "UDDDUDUU";
        int steps = 12; // expected output: 2
        String path = "DDUUDDUDUUUD";
        int result = Result.countingValleys(steps, path);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    public static int countingValleys(int steps, String path) {
        int valleysCounter = 0;
        int count = 0;
        boolean notMountain = false;
        for (int i = 0; i < path.length(); i++) {
            final char direction = path.charAt(i);
            if ('D' == direction) {
                count--;
            } else if ('U' == direction) {
                count++;
            }

            if (count < 0) {
                notMountain = true;
            }

            if (notMountain && count == 0) {
                valleysCounter++;
                notMountain = false;
            }
        }

        return valleysCounter;
    }

}
