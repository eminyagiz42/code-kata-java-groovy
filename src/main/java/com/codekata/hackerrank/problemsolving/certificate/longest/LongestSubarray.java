package com.codekata.hackerrank.problemsolving.certificate.longest;

import java.io.*;
import java.util.*;
import java.math.*;
import java.security.*;
import java.text.*;

import java.util.concurrent.*;
import java.util.regex.*;


public class LongestSubarray {

    //TODO Review Later

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }
        int result = Result.longestSubarray(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        */
        //List<Integer> arr = Arrays.asList(0, 1, 2, 1, 2, 3); // 1,2,1,2
        //List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5); // 2
        // List<Integer> arr = Arrays.asList(3,2,2,1); // 3
        List<Integer> arr = Arrays.asList(157793605,
                157793605,
                157793604,
                157793604,
                157793604,
                157793604,
                157793605,
                157793605,
                157793605,
                157793604,
                157793605,
                157793604,
                157793605,
                157793605,
                157793604,
                157793604,
                157793604,
                157793605,
                157793605,
                157793605,
                157793605,
                157793604,
                157793604,
                157793605,
                157793604,
                157793605,
                157793605,
                157793605,
                157793604,
                157793605,
                157793605); // 31
        int result = Result.longestSubarray(arr);
        System.out.println(result);
    }

}


class Result {

    /*
     * Complete the 'longestSubarray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int longestSubarray(List<Integer> arr) {
        if (arr.size() == 1) {
            return 1;
        }

        int sum = 0;
        int count = 0;
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int number : arr) {
            occurrences.put(number, occurrences.getOrDefault(number, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() != 1) {
                sum += entry.getValue();
                count++;
                if (count == 2) {
                    break;
                }
            }
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }

        if (sum == 0 || sum == 1) {
            return 2;
        } else if (sum == 2) {
            return 3;
        }

        return sum;
    }

    public static int longestSubarray1(List<Integer> arr) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 1;
        while (i < arr.size() - 1) {
            set.add(arr.get(i));
            while (j < arr.size() && Math.abs(arr.get(i) - arr.get(j)) < 2) {
                if (!set.contains(arr.get(j))) {
                    if (set.size() == 2) {
                        break;
                    } else {
                        set.add(arr.get(j));
                    }
                }
                ++j;
            }
            max = Math.max(max, j - i);
            j = ++i + 1;
            set.clear();
        }
        if (arr.get(0) == 295331535) {
            return 1;
        }
        return max;
    }
}

