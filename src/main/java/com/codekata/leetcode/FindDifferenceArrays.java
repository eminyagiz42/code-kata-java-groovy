package com.codekata.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class FindDifferenceArrays {

    public static void main(String[] args) {
        //https://leetcode.com/problems/find-the-difference-of-two-arrays

        int[] nums1 = {1,2,3}, nums2 = {2,4,6};
        // int[] nums1 = {1,2,3,3}, nums2 = {1,1,2,2};
        final List<List<Integer>> difference = findDifference(nums1, nums2);

        for (List<Integer> diff :difference) {
            for (Integer d : diff) {
                System.out.print(d + " ");
            }
            System.out.println("");
        }
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) { //152 ms
        List<List<Integer>> listList = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> arr1 = new ArrayList<>(set1);
        List<Integer> arr2 = new ArrayList<>(set2);
        List<Integer> temp1 = new ArrayList<>(set1);
        arr1.removeAll(arr2);
        arr2.removeAll(temp1);

        listList.add(arr1);
        listList.add(arr2);

        return listList;
    }

    public static List<List<Integer>> findDifferenceStream(int[] nums1, int[] nums2) { //13 ms

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Arrays.stream(nums1).forEach(set2::remove);
        Arrays.stream(nums2).forEach(set1::remove);
        return Arrays.asList(new ArrayList<>(set1), new ArrayList<>(set2));
    }
}

