package com.codekata.leetcode.interview75.first25;

/**
 * The type Increasing triplet.
 */
class IncreasingTriplet {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

		// https://leetcode.com/problems/increasing-triplet-subsequence

		//int[] productQuantity = { 1,2,3,4,5};
		//int[] productQuantity = { 5,4,3,2,1};
		//int[] productQuantity = {2,1,5,0,4,6};
		//int[] productQuantity = { 20,100,10,12,5,13};
		//int[] productQuantity = {0,4,2,1,0,-1,-3};
		int[] productQuantity = {20,100,10,12,5,13};

		System.out.println(increasingTriplet(productQuantity));
	}

    /**
     * Increasing triplet boolean.
     *
     * @param nums the nums
     * @return the boolean
     */
    public static boolean increasingTriplet(int[] nums) {
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;

		for (int num : nums) {
			if (num <= firstMin) {
				firstMin = num;
			} else if (num <= secondMin) {
				secondMin = num;
			} else {
				return true;
			}
		}
		return false;
	}


    /**
     * Increasing triplet slow boolean.
     *
     * @param nums the nums
     * @return the boolean
     */
    public static boolean increasingTripletSlow(int[] nums) { // 2nd Solution - Slower approach
		for (int i = 0; i < nums.length; i++) {
			int currentNumber = nums[i];
			for (int j = i+1; j < nums.length; j++) {
				if (nums[j] > currentNumber) {
					for (int k = j+1; k < nums.length; k++) {
						if (nums[k] > nums[j]) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}