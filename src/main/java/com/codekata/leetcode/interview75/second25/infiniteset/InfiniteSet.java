package com.codekata.leetcode.interview75.second25.infiniteset;

public class InfiniteSet {

    public static void main(String[] args) {

        SmallestInfiniteSet infiniteSet = new SmallestInfiniteSet(); System.out.println();

        infiniteSet.addBack(2);System.out.println();

        System.out.println(infiniteSet.popSmallest());
        System.out.println(infiniteSet.popSmallest());
        System.out.println(infiniteSet.popSmallest());

        infiniteSet.addBack(1);System.out.println();

        System.out.println(infiniteSet.popSmallest());
        System.out.println(infiniteSet.popSmallest());
        System.out.println(infiniteSet.popSmallest());
    }
}
