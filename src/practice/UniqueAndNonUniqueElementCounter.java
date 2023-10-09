package practice;

import java.util.HashMap;
import java.util.Map;


public class UniqueAndNonUniqueElementCounter {
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

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 2, 4, 5, 6, 1};
		Map<Integer, Integer> elementCounts = countUniqueAndNonUniqueElements(array);

		System.out.println("Element Counts:");
		for (Map.Entry<Integer, Integer> entry : elementCounts.entrySet()) {
			System.out.println("Element: " + entry.getKey() + ", Count: " + entry.getValue());
		}
	}
}
