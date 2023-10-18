package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxOperation {

    public static void main(String[] args) {

        //https://leetcode.com/problems/max-number-of-k-sum-pairs

        int[] nums = {3,1,3,4,3};
        int k = 6;

        //int[] nums = {1,2,3,4};
        //int k = 5;
        System.out.print(maxOperations(nums, k));
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] > k)
                end--;
            else if (nums[start] + nums[end] < k)
                start++;
            else {
                start++;
                end--;
                result++;
            }
        }
        return result;
    }


    // TODO 18 / 51 testcases passed
    public static int maxOperations2(int[] nums, int k) {
        List<Integer> collection = new ArrayList<>();
        int counter = 0;
        int firstIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!collection.contains(i)) {
                firstIndex = i;
                int remained = k - nums[firstIndex];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == remained) {
                        collection.add(firstIndex);
                        collection.add(j);
                        //nums = removeElement(nums, i, j);
                        counter++;
                        break;
                    }
                }
            }
        }
        return counter;
    }

    public static int[] removeElement(int[] nums, int firstIndex, int secondIndex) { // Use it by iterator.
        int[] newArr = new int[nums.length - 2];
        int newIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != firstIndex && i != secondIndex) {
                newArr[newIndex] = nums[i];
                newIndex++;
            }
        }
        return newArr;
    }
}

