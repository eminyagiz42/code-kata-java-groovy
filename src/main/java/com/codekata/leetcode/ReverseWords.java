package com.codekata.leetcode;

import java.util.ArrayList;
import java.util.List;

class ReverseWords {

	public static void main(String[] args) {

		// https://leetcode.com/problems/reverse-words-in-a-string

		System.out.println(reverseWords("a good   example")); // output : example good a
	}

	public static String reverseWords(String s) {
		return String.join(" ", reverseList(s.trim().replaceAll(" +", " ").split(" ")));
	}

	public static List<String> reverseList(String[] alist) {
		List<String> revArrayList = new ArrayList<>();
		for (int i = alist.length- 1; i >= 0; i--) {
			revArrayList.add(alist[i]);
		}
		return revArrayList;
	}
}