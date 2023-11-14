package com.codekata.practice.challanges;

public class FrequentElementChallange {
    public static void main(String[] args) {

        //int[] arr = {5,5,2,2,1};
        //int[] arr = {3,4,1,6,10};
        int[] arr = {5, 10, 10, 6, 5};
        System.out.println(arrayChallenge(arr));
    }

    private static int arrayChallenge(int[] arr) {
        int frequent = 0;
        int highest = 0;
        int saved = 0;
        for (int j : arr) {
            for (int k : arr) {
                if (j == k) {
                    frequent++;
                }
            }
            if (highest != frequent) {
                highest = Math.max(highest, frequent);
                if (highest == frequent) {
                    saved = j;
                }
            }
            frequent = 0;
        }

        if (highest == 1) {
            return -1;
        } else {
            return saved;
        }
    }
}
