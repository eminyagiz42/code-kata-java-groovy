package com.codekata.hackerrank.problemsolving.sales;


import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class SockMerchant {

    //https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int result = Result.sockMerchant(n, ar);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
         */

        //List<Integer> ar = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);
        //int n = 9; //Expected output: 3
        List<Integer> ar = Arrays.asList(1, 1, 3, 1, 2, 1, 3, 3, 3, 3);
        int n = 10; //Expected output: 4
        int result = Result.sockMerchant(n, ar);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */
    public static int sockMerchant(int n, List<Integer> ar) { // It calculates the pairs of socks
        Map<Integer, Integer> socks = new HashMap<>();
        for (int number : ar) {
            socks.put(number, socks.getOrDefault(number, 0) + 1);
        }

        int count = 0;
        for (int sock : socks.values()) {
            count += sock / 2;
        }

        return count;
    }

    public static int sockMerchantAloneSocks(int n, List<Integer> ar) { // It calculates alone socks
        Map<Integer, Integer> socks = new HashMap<>();
        for (int number : ar) {
            socks.put(number, socks.getOrDefault(number, 0) + 1);
        }

        int count = 0;
        for (int sock : socks.values()) {
            if (sock % 2 == 1) {
                count++;
            }
        }

        return count;
    }

}
