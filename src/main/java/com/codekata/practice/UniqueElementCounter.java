package com.codekata.practice;

import java.util.*;

/**
 * The type Unique element counter.
 */
public class UniqueElementCounter {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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



		int[] array = {1, 2, 3, 2, 4, 5, 6, 1};
		Map<Integer, Integer> elementCounts = countUniqueAndNonUniqueElements(array);

		System.out.println("Element Counts:");
		for (Map.Entry<Integer, Integer> entry : elementCounts.entrySet()) {
			System.out.println("Element: " + entry.getKey() + ", Count: " + entry.getValue());
		}
	}

    /**
     * Count unique elements int.
     *
     * @param array the array
     * @return the int
     */
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

    /**
     * Count unique and non unique elements map.
     *
     * @param array the array
     * @return the map
     */
    public static Map<Integer, Integer> countUniqueAndNonUniqueElements(int[] array) {
		if (array == null || array.length == 0) {
			return null; // Return null for empty or null arrays
		}

		Map<Integer, Integer> elementCounts = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			int currentElement = array[i];
			if (elementCounts.containsKey(currentElement)) {
				elementCounts.put(currentElement, elementCounts.get(currentElement) + 1);
			} else {
				elementCounts.put(currentElement, 1);
			}
		}

		return elementCounts;
	}
}