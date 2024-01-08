package com.codekata.hackerrank.daysofcode.second10.day20;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Day20 {

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        bufferedReader.close();
         */

        int n = 3;
        List<Integer> a = Arrays.asList(3, 2, 1);
        System.out.println("Array is sorted in " + getNumberOfSwaps(n, a) + " swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(a.size() - 1));
    }

    private static int getNumberOfSwaps(int n, List<Integer> a) {
        int numberOfSwaps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a.get(j) > a.get(j + 1)) {
                    swap(a, j, j + 1);
                    numberOfSwaps++;
                }
            }
            if (numberOfSwaps == 0) {
                break;
            }
        }
        return numberOfSwaps;
    }

    public static void swap(List<Integer> arr, int first, int second) {
        int tmp = arr.get(first);
        arr.set(first, arr.get(second));
        arr.set(second, tmp);
    }
}
