package com.codekata.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Name pair counter.
 */
public class NamePairCounter {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		String[] input = {
				"john tom",
				"john mary",
				"john tom",
				"mary anna",
				"mary anna"
		};

		Map<String, Integer> pairCounts = new HashMap<>();

		for (String pair : input) {
			if (pairCounts.containsKey(pair)) {
				pairCounts.put(pair, pairCounts.get(pair) + 1);
			} else {
				pairCounts.put(pair, 1);
			}

			System.out.println(pairCounts.get(pair));
		}
	}
}