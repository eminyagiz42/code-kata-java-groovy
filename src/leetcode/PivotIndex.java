package leetcode;

public class PivotIndex {

    public static void main(String[] args) {

        //https://leetcode.com/problems/find-pivot-index/

        int[] nums = {1,7,3,6,5,6};
        System.out.print(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                sumLeft += nums[j];
            }
            for (int j = i+1; j < nums.length; j++) {
                sumRight += nums[j];
            }
            if (sumLeft == sumRight) {
                return i;
            }
            sumLeft = 0;
            sumRight = 0;
        }
        return -1;
    }

}

