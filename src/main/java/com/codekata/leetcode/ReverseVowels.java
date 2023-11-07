package com.codekata.leetcode;

import java.util.*;

class ReverseVowels {

	public static List<String> vowels = Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");

	public static void main(String[] args) {

		// https://leetcode.com/problems/reverse-vowels-of-a-string

		// System.out.println(reverseVowels("HelloWorlde"));
		// System.out.println(reverseVowels("A man, a plan, a canal: Panama"));
		// System.out.println(reverseVowels("race car"));
		System.out.println(reverseVowels("com/eminyagiz/leetcode"));
	}

	public static String reverseVowels(String s) {

		List<Integer> keyList = new ArrayList<>();
		List<String> valueList = new ArrayList<>();
		String[] splitedStr = s.split("");

		for (int i = 0; i < splitedStr.length; i++) {
			if (vowels.contains(splitedStr[i])) {
				keyList.add(i);
				valueList.add(splitedStr[i]);
			}
		}

		keyList = reverseArrayList(keyList);

		for (int i = 0; i <keyList.size(); i++) {
			splitedStr[keyList.get(i)] = valueList.get(i);
		}

		return String.join("", splitedStr);
	}

	public static List<Integer> reverseArrayList(List<Integer> alist) {
		List<Integer> revArrayList = new ArrayList<>();
		for (int i = alist.size() - 1; i >= 0; i--) {
			revArrayList.add(alist.get(i));
		}
		return revArrayList;
	}

	/* This solution is out of scope. It works to swapping every two vowels pair
	public static String reverseVowels(String s) {
		List<String> vowels = Arrays.asList("a","e","i","o","u", "A","E","I","O","U");
		final String[] splitedStr = s.split("");
		Integer from = null;
		Integer to = null;
		boolean updated = false;

		for (int i = 0; i < splitedStr.length; i++) {
			if (vowels.contains(splitedStr[i])) {
				if (!updated) {
					if (from == null) {
						from = i;
					} else {
						if (!splitedStr[from].equals(splitedStr[i])) {
							to = i;
							if (to == String.join("", splitedStr).lastIndexOf(splitedStr[to])) {
								String tmp = splitedStr[from];
								splitedStr[from] = splitedStr[to];
								splitedStr[to] = tmp;
								updated = true;
							}
						} else {
							from = i;
						}
					}
				} else {
					from = i;
					updated = false;
				}
			}
		}
		return String.join("", splitedStr);
	}
	 */
}