package com.codekata.curiousity;


import com.codekata.hackerrank.java.SingletonProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch2Notes {

    //TODO Review Later

    public static void main(String[] args) {

        List<Integer> ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
        List<Integer> player = Arrays.asList(5, 25, 50, 120); // 6, 4, 2, 1

        /*
        final List<List<Integer>> rankAndOrderList = getRankAndOrderList(ranked);
        Collections.reverse(rankAndOrderList);
        for (int play : player) {
            final int meBinarySmaller = findMeBinarySmaller(rankAndOrderList, play, 0, rankAndOrderList.size() - 1);
            System.out.println(meBinarySmaller);
        }

         */
    }

    private static int findMeBinarySmaller(List<List<Integer>> nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        final int middle = ((int) Math.floor((start + end) / 2));

        if (start != 0 && start == end) {
            int index = nums.get(middle).get(1) + 1;
            nums.add(Arrays.asList(target, index));
            return nums.get(middle).get(1) + 1;
        }

        if (nums.get(middle).get(0) == target) {
            return middle;
        }
        if (nums.get(middle).get(0) > target) {
            return findMeBinarySmaller(nums, target, start, middle - 1);
        }
        if (nums.get(middle).get(0) < target) {
            return findMeBinarySmaller(nums, target, middle + 1, end);
        } else {
            return -1;
        }
    }


    private static List<List<Integer>> getRankAndOrderList(List<Integer> ranked) {
        List<List<Integer>> rankAndOrder = new ArrayList<>();

        List<Integer> numberList = new ArrayList<>();
        for (int i : ranked) {
            if (!numberList.contains(i)) {
                numberList.add(i);
            }
        }

        int index = 1;
        for (Integer num : numberList) {
            rankAndOrder.add(Arrays.asList(num, index++));
        }

        rankAndOrder.add(Arrays.asList(0, index));
        return rankAndOrder;
    }


    private static List<List<Integer>> getRankAndOrderList2(List<Integer> ranked) {

        List<Integer> numberList = new ArrayList<>();
        for (int i : ranked) {
            if (!numberList.contains(i)) {
                numberList.add(i);
            }
        }

        List<List<Integer>> rankAndOrder = new ArrayList<>();

        rankAndOrder.add(Arrays.asList(numberList.get(0), 1));

        int index = 1;
        if (numberList.size() > 1 && numberList.get(0).equals(numberList.get(1))) {
            rankAndOrder.add(Arrays.asList(numberList.get(0), index));
        }

        for (int i = 1; i < numberList.size(); i++) {
            if (!numberList.get(i).equals(numberList.get(i - 1))) {
                index++;
            }
            rankAndOrder.add(Arrays.asList(numberList.get(i), index));
        }

        rankAndOrder.add(Arrays.asList(0, ++index));
        return rankAndOrder;
    }
}

class LeaderBoardModel {
    private int newRank;
    private int newScore;
    private static List<List<Integer>> rankAndScore;

    public static List<List<Integer>> getSingleInstance(){
        if(rankAndScore == null){
            rankAndScore = new ArrayList<>();
        }
        return rankAndScore;
    }


    public int getRank() {
        return newRank;
    }

    public void setRank(int rank) {
        this.newRank = rank;
    }

    public int getNewScore() {
        return newScore;
    }

    public void setNewScore(int score) {
        this.newScore = score;
    }
}
