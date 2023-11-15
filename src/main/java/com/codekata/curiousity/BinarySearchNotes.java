package com.codekata.curiousity;


public class BinarySearchNotes {

    public static void main(String[] args) {
        int h = 90293;
        int index = 0;
        int[] billion = new int[1_000_000_000];
        for (int i = 999_999_999; i >= 0; i--) {
            billion[index++] = i;
        }

        long start = System.currentTimeMillis();
        final int findByLoop = findMe(billion, h);
        System.out.println(findByLoop);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("for loop O(n) timeElapsed = " + timeElapsed); // 22 ms  or 255 ms


        long start1 = System.currentTimeMillis();
        // Arrays.sort(billion); 1000ms for 1 billion elements
        final int meBinary = findMeBinary(billion, h, 0, billion.length - 1);
        System.out.println(meBinary);
        long finish1 = System.currentTimeMillis();
        long timeElapsed1 = finish1 - start1;
        System.out.println("binary search O(logn) timeElapsed = " + timeElapsed1); // less than 0 ms but not always good
    }

    private static int findMe(int[] nums, int h) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == h) {
                return i;
            }
        }
        return -1;
    }

    private static int findMeBinary(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        final int middle = ((int) Math.floor((start + end) / 2));

        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > target) {
           return findMeBinary(nums, target, start, middle - 1);
        }
        if (nums[middle] < target) {
          return findMeBinary(nums, target, middle + 1, end);
        } else {
            return -1;
        }
    }
}
