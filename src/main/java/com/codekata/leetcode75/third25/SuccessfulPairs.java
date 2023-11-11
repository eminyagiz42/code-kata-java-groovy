package com.codekata.leetcode75.third25;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SuccessfulPairs {

    public static void main(String[] args) {

        //https://leetcode.com/problems/successful-pairs-of-spells-and-potions/

        int[] spells = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int[] potions = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        long success = 3l;
        final int[] ints = successfulPairs(spells, potions, success);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] resultArr = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; ++i) {
            resultArr[i] = potions.length - firstIndexSuccess(spells[i], potions, success);
        }
        return resultArr;
    }

    private static int firstIndexSuccess(int spell, int[] potions, long success) {
        int count = 0;
        int length = potions.length;
        while (count < length) {
            final int m = (count + length) / 2;
            if ((long) spell * potions[m] >= success) {
                length = m;
            } else{
                count = m + 1;
        }}
        return count;
    }
}