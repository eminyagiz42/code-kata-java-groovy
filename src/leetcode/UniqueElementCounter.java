package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UniqueElementCounter {
	public static int countUniqueElements(ArrayList array) {
		if (array == null || array.size() == 0) {
			return 0; // Return 0 for empty or null arrays
		}

		Set<String> uniqueElements = new HashSet<>();
		int count = 1;

		for (int i = 1; i < array.size(); i++) {
			if (!uniqueElements.contains(array.get(i))) {
				//uniqueElements.add(array.get(i));
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		String a1 = "john"; String b1 = "tom";
		String a2 = "john"; String b2 = "mary";
		String a3 = "john"; String b3 = "tom";
		String a4 = "mary"; String b4 = "anna";
		String a5 = "mary"; String b5 = "anna";




		String [] pair_left = {a1,a2,a3,a4,a5};
		String [] pair_right = {b1,b2,b3,b4,b5};

		ArrayList arrList = new ArrayList<String>();

		for (int i =0 ; i < pair_left.length; i++) {
			arrList.add(pair_left[i] + " " +  pair_right[i]);
		}
		int uniqueCount = countUniqueElements(arrList);
		System.out.println("Number of unique elements: " + uniqueCount);
	}
}