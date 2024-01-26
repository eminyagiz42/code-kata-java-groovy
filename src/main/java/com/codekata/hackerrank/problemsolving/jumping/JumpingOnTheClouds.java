package com.codekata.hackerrank.problemsolving.jumping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class JumpingOnTheClouds {

    //https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] cTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cTemp[i]);
            c.add(cItem);
        }
        int result = Result.jumpingOnClouds(c);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */
    public static int jumpingOnClouds(List<Integer> c) {

        final int[] clouds = new int[c.size()];
        for (int i = 0; i < c.size(); i++) {
            clouds[i] = c.get(i);
        }

        int noOfJumps = 0, i = 0;
        while (true) {
            if (i + 2 < c.size() && clouds[i + 2] == 0) {
                i += 2;
            } else if (i + 1 < c.size()) {
                i++;
            } else {
                break;
            }
            noOfJumps++;
        }

        return noOfJumps;
    }

}