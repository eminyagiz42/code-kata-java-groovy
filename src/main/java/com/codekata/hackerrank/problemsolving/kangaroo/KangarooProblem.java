package com.codekata.hackerrank.problemsolving.kangaroo;


import java.io.*;


public class KangarooProblem {

    //https://www.hackerrank.com/challenges/kangaroo/problem

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int x1 = Integer.parseInt(firstMultipleInput[0]);
        int v1 = Integer.parseInt(firstMultipleInput[1]);
        int x2 = Integer.parseInt(firstMultipleInput[2]);
        int v2 = Integer.parseInt(firstMultipleInput[3]);
        String result = Result.kangaroo(x1, v1, x2, v2);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        */
        //int x1 = 0, v1 = 3, x2 = 4, v2 = 2; // YES
        int x1 = 0, v1 = 2, x2 = 5, v2 = 3; // NO
        String result = Result.kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        int oneLocation = 0;
        int twoLocation = 0;
        for (int i = 0; i < 10_000; i++) {
            oneLocation = x1 + v1 * i;
            twoLocation = x2 + v2 * i;
            //System.out.println(oneLocation +" - "+ twoLocation);
            if (oneLocation == twoLocation) {
                return "YES";
            }
        }

        return "NO";
    }

}



