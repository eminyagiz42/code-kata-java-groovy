package com.codekata.hackerrank;

import java.util.Scanner;


public class JavaSubstringComparisons {

	//Problem: https://www.hackerrank.com/challenges/java-string-compare/problem

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();
		System.out.println(getSmallestAndLargest(s, k));
	}

	public static String getSmallestAndLargest(String str, int k) {
		String array[] = str.split("");
		String newArray[] = new String[str.length()];
		StringBuilder stringBuilder = new StringBuilder();
		for (int f = 0; f < newArray.length - k + 1; f++) {
			for (int m = 0 + f; m < k + f; m++) {
				stringBuilder.append(array[m]);
			}
			String temp = stringBuilder.toString();
			newArray[f] = temp;
			stringBuilder.delete(0, stringBuilder.length());
		}
		sortLex(newArray, k);
		String smallest = newArray[0];
		String largest = newArray[str.length() - k];
		return smallest + "\n" + largest;
	}

	public static void sortLex(String[] words, int num) {
		for (int i = 0; i < words.length - num; ++i) {
			for (int j = i + 1; j < words.length - num + 1; ++j) {
				if (words[i].compareTo(words[j]) > 0) {
					String temp = words[i];
					words[i] = words[j];
					words[j] = temp;
				}
			}
		}
	}
}