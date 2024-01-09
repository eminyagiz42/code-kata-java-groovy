package com.codekata.hackerrank.problemsolving.utopia;


import java.io.*;


public class UtopiaTree {

    //https://www.hackerrank.com/challenges/utopian-tree/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                int result = Result.utopianTree(n);
                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        bufferedWriter.close();
         */
        int n1 = 0; // expected output: 1
        int result1 = Result.utopianTree(n1);
        System.out.println(result1);

        int n2 = 1; // expected output: 2
        int result2 = Result.utopianTree(n2);
        System.out.println(result2);

        int n3 = 4; // expected output: 7
        int result3 = Result.utopianTree(n3);
        System.out.println(result3);
    }
}

class Result {

    /*
     * Complete the 'utopianTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    public static int utopianTree(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                sum++;
            } else {
                sum *= 2;
            }
        }
        return sum;
    }

}
