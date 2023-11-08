package com.codekata.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Reverse words.
 */
class ReverseWords {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

		// https://leetcode.com/problems/reverse-words-in-a-string

		System.out.println(reverseWords("a good   example")); // output : example good a
	}

    /**
     * Reverse words string.
     *
     * @param s the s
     * @return the string
     */
    public static String reverseWords(String s) {
		return String.join(" ", reverseList(s.trim().replaceAll(" +", " ").split(" ")));
	}

    /**
     * Reverse list list.
     *
     * @param alist the alist
     * @return the list
     */
    public static List<String> reverseList(String[] alist) {
		List<String> revArrayList = new ArrayList<>();
		for (int i = alist.length- 1; i >= 0; i--) {
			revArrayList.add(alist[i]);
		}
		return revArrayList;
	}
}