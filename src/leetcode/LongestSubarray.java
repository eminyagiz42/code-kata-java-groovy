package leetcode;

public class LongestSubarray {
    public static void main(String[] args) {

        //https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element

        int[] nums = {1,1,0,1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int before = 0, current = 0, result = 0;
        for (int num : nums) {
            if (num == 1) {
                current++;
            } else {
                before = current;
                current = 0;
            }
            result = Math.max(result, before + current);
        }
        if (result == nums.length) {
            return result - 1;
        }
        return result;
    }
}
