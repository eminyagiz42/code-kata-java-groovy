package com.codekata.leetcode.interview75.first25;

import java.util.*;

/**
 * The type Unique occurrences.
 */
public class UniqueOccurrences {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/unique-number-of-occurrences/

        int[] arr = {1, 2, 2, 1, 1, 3};
        //int[] arr = {26,2,16,16,5,5,26,2,5,20,20,5,2,20,2,2,20,2,16,20,16,17,16,2,16,20,26,16}; // [16, 17, 2, 20, 5, 26]
        System.out.println(uniqueOccurrences(arr));
    }

    /**
     * Unique occurrences boolean.
     *
     * @param arr the arr
     * @return the boolean
     */
    public static boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set1 = convertToSet(arr);
        int[] occurrences = getOccurrences(arr, set1);
        Set<Integer> set2 = convertToSet(occurrences);
        return occurrences.length == set2.size();
    }

    private static int[] getOccurrences(int[] arr, Set<Integer> set1) {
        int[] occurrences = new int[set1.size()];
        final Iterator<Integer> iterator = set1.iterator();
        int count = 0;
        int index = 0;
        while (iterator.hasNext()) {
            int num = iterator.next();
            for (int j : arr) {
                if (num == j) {
                    count++;
                }
            }
            occurrences[index++] = count;
            count = 0;
        }
        return occurrences;
    }

    private static Set<Integer> convertToSet(int[] occurrences) {
        Set<Integer> uniqueOccurrences = new HashSet<>();
        for (int s1 : occurrences) {
            uniqueOccurrences.add(s1);
        }
        return uniqueOccurrences;
    }


    /**
     * Out of scope: This solution is checking that,
     * if only one element in arr is unique, and other is duplicated returns true
     *
     * @param arr the arr
     * @return the boolean
     */
    public static boolean uniqueOccurrencesOutOfScope(int[] arr) {
        Set<Integer> set1 = convertToSet(arr);
        final Iterator<Integer> iterator = set1.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            int num = iterator.next();
            for (int j : arr) {
                if (num == j) {
                    count++;
                }
            }
            if (count >= 2) {
                iterator.remove();
            }
            count = 0;
        }
        return set1.size() == 1;
    }
}
