package com.codekata.hackerrank.problemsolving.sorted;

import java.io.IOException;
import java.util.*;


public class AlmostSortedProblem {

    //https://www.hackerrank.com/challenges/almost-sorted/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        Result.almostSorted(arr);
        bufferedReader.close();
         */

        List<Integer> arr = Arrays.asList(4, 2); //yes \n swap 1 2
        //List<Integer> arr = Arrays.asList(3, 1, 2); //no
        //List<Integer> arr = Arrays.asList(1, 5, 4, 3, 2, 6); //yes \n reverse 2 5
        Result.almostSorted(arr);
    }
}


class Result {

    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void almostSorted(List<Integer> arr) {
        if (isSorted(arr)) {
            System.out.println("yes");
        } else {
            //Detecting first and second before swaping
            int i, first = -1, second = -1;
            for (i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    if (first == -1) {
                        first = i;
                    } else {
                        second = i + 1;
                    }
                }
            }

            if (second == -1) {
                second = first + 1;
            }

            swap(arr, first, second);

            if (isSorted(arr)) {
                System.out.println("yes\nswap " + (first + 1) + " " + (second + 1));
                return;
            }

            swap(arr, second, first);
            Collections.reverse(arr.subList(first, second + 1));
            if (isSorted(arr)) {
                System.out.println("yes\nreverse " + (first + 1) + " " + (second + 1));
                return;
            }
        }
        System.out.println("no");
    }

    public static boolean isSorted(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1) > arr.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void swap(List<Integer> arr, int first, int second) {
        int tmp = arr.get(first);
        arr.set(first, arr.get(second));
        arr.set(second, tmp);
    }

    /*
    public static final int COMPLETELY_SAME = 0;
    public static final int HAS_SUBLIST = 1;

    public static void almostSorted(List<Integer> arr) { // This solution has some bugs, not solving all test cases
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);
        List<Integer> subArray = getSubArrayOfDifferentElements(arr, sorted);
        Collections.reverse(subArray);

        final int hasSubList = Collections.indexOfSubList(sorted, subArray);
        if (hasSubList == HAS_SUBLIST || hasSubList == COMPLETELY_SAME) {
            String operation = "";
            if (subArray.size() == 2) {
                operation = "swap ";
            } else {
                operation = "reverse ";
            }
            System.out.println("yes\n" + operation + (arr.indexOf(subArray.get(subArray.size() - 1)) + 1) + " " + (arr.indexOf(subArray.get(0)) + 1));
        } else {
            System.out.println("no");
        }
    }

    private static List<Integer> getSubArrayOfDifferentElements(List<Integer> arr, List<Integer> sorted) {
        List<Integer> subArray = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).equals(sorted.get(i))) {
                subArray.add(arr.get(i));
            }
        }
        return subArray;
    }

     */
}
