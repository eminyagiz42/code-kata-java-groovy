package com.codekata.hackerrank.problemsolving.append;

import java.io.*;


public class AppendAndDelete {

    //https://www.hackerrank.com/challenges/append-and-delete/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = bufferedReader.readLine();
        String t = bufferedReader.readLine();
        int k = Integer.parseInt(bufferedReader.readLine().trim());
        String result = Result.appendAndDelete(s, t, k);
        //bufferedWriter.write(result);
        //bufferedWriter.newLine();
        //bufferedWriter.close();
        bufferedReader.close();
        */
        //String result = Result.appendAndDelete("hackerhappy", "hackerrank", 9);
        String result = Result.appendAndDelete("abcd ", "abcdert ", 10);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */
    public static String appendAndDelete(String s, String t, int k) {
        if (s.length() + t.length() <= k) {
            return "Yes";
        }
        int shortest = Math.min(s.length(), t.length());
        int commonLength = 0;
        for (int i = 0; i < shortest; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                commonLength++;
            } else {
                break;
            }
        }

        final int numOfProcess = s.length() + t.length() - (2 * commonLength);

        if (numOfProcess <= k) {
            if ((numOfProcess - k) % 2 == 0) {
                return "Yes";
            }
        }
        return "No";
    }
}
