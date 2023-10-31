package leetcode;

import java.util.Arrays;

class ProductExceptSelf {

	public static void main(String[] args) {

		// https://leetcode.com/problems/product-of-array-except-self

		int[] productQuantity = { 1,2,3,4};
		System.out.println(Arrays.toString(productExceptSelf(productQuantity)));
	}

	public static int[] productExceptSelf(int[] nums) { // 2nd solution with quicker algorithm
		int n = nums.length;
		int totalMultiple = 1;
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = totalMultiple;
		}

		for (int i = 0; i < n; i++) {
			result[i] *= totalMultiple;
			totalMultiple *= nums[i];
		}
		totalMultiple = 1;
		for (int i = n - 1; i >= 0; i--) {
			result[i] *= totalMultiple;
			totalMultiple *= nums[i];
		}
		return result;
	}

	public static int[] productExceptSelfSlower(int[] nums) { // 1st solution: this has O(n)^2 complexity, in large array it might take too long
		int[] calculationResults = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int totalMultiple = 1;
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					totalMultiple = totalMultiple * nums[j];
				}
			}
			calculationResults[i]= totalMultiple;
		}
		return calculationResults;
	}
}