package com.codekata.hackerrank.problemsolving.drawing;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DrawingBook {

    //https://www.hackerrank.com/challenges/drawing-book/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int p = Integer.parseInt(bufferedReader.readLine().trim());
        int result = Result.pageCount(n, p);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
         */
        //int n = 6, p = 2; // expected output: 1
        //int n = 5, p = 4; // expected output: 0
        //int n = 60113, p = 8589; // expected output: 4294
        int n = 2, p = 1; // expected output: 0
        int result = Result.pageCount(n, p);
        System.out.println(result);

    }
}


class Result {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */
    public static int pageCount(int n, int p) {
        final List<String> books = getBooks(n);

        int pageFlipTop = flipPages(books, p);

        Collections.reverse(books);

        int pageFlipBottom = flipPages(books, p);

        return Math.min(pageFlipTop, pageFlipBottom);
    }

    private static int flipPages(List<String> books, int pageNumber) {
        int pageFlip = 0;
        for (String paper : books) {
            if (paper.contains("-" + pageNumber + "-")) {
                return pageFlip;
            }
            pageFlip++;
        }
        return 0;
    }

    private static List<String> getBooks(int n) {
        List<String> arr = new ArrayList<>();
        arr.add("1");
        for (int i = 1; i <= n / 2; i++) {
            //System.out.println((2 * i) + " and " + ((2 * i) + 1));
            arr.add("-" + (2 * i) + "-" + " and " + "-" + ((2 * i) + 1) + "-");
        }
        return arr;
    }

}