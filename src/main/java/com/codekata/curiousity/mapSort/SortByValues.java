package com.codekata.curiousity.mapSort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortByValues {

    //TODO Review Later

    public static void main(String[] args) {

        Map<Integer, Integer> unsortMap = new HashMap<>();

        List<Integer> ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
        List<Integer> player = Arrays.asList(5, 25, 50, 120); // 6, 4, 2, 1


        final List<Integer> integerList = ranked.stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < player.size(); i++) {
            int meBinarySmaller = findMeBinarySmaller(integerList, player.get(i), 0, integerList.size()-1);
            System.out.println(meBinarySmaller);
        }

    }


    private static int findMeBinarySmaller(List<Integer> nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        final int middle = ((int) Math.floor((start + end) / 2));

        if (start != 0 && start == end) {

            return nums.indexOf(nums.get(middle-1));
        }

        if (nums.get(middle) == target) {
            return middle;
        }
        if (nums.get(middle) > target) {
            return findMeBinarySmaller(nums, target, start, middle - 1);
        }
        if (nums.get(middle) < target) {
            return findMeBinarySmaller(nums, target, middle + 1, end);
        } else {
            return -1;
        }
    }
}
