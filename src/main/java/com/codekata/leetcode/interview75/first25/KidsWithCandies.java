package com.codekata.leetcode.interview75.first25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * The type Kids with candies.
 */
class KidsWithCandies {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

		// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies

		int[] candies = {2,3,5,1,3 };
		final List<Boolean> kidsResult = kidsWithCandies(candies, 3);
		for (Boolean result : kidsResult) {
			System.out.print(result + ", ");
		}
	}

    /**
     * Kids with candies list.
     *
     * @param candies      the candies
     * @param extraCandies the extra candies
     * @return the list
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> kidsResult = new ArrayList<>();
		int max = Arrays.stream(candies).max().getAsInt();
		for (int candy : candies){
			kidsResult.add((candy + extraCandies) >= max);
		}
		return kidsResult;
	}
}