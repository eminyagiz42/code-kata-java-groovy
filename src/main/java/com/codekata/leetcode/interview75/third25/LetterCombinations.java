package com.codekata.leetcode.interview75.third25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {
        //https://leetcode.com/problems/letter-combinations-of-a-phone-number

        //String digits = "23"; // Expected output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        //String digits = "2"; // ["a","b","c"]
        //String digits = "22"; // [aa, ab, ac, ba, bb, bc, ca, cb, cc]
        String digits = "234";
        //System.out.println(letterCombinations(digits));
        System.out.println(combineStringsNew(letters[1], letters[1]));
    }

    public List<String> letterCombinations(String digits) { //First Approach DFS
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        final StringBuilder builder = new StringBuilder();
        depthFirstSearch(digits, 0, builder, ans);
        return ans;
    }

    private static final String[] digitToLetters = {"", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void depthFirstSearch(String digits, int i, StringBuilder sb, List<String> ans) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        final String digitToLetter = digitToLetters[digits.charAt(i) - '0'];
        for (final char c : digitToLetter.toCharArray()) {
            sb.append(c);
            depthFirstSearch(digits, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinationsIterative(String digits) { // Second solution by iterative approach
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> combinations = new ArrayList<>();
        combinations.add("");

        for (final char d : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (final String s : combinations)
                for (final char c : digitToLetters[d - '0'].toCharArray())
                    temp.add(s + c);
            combinations = temp;
        }

        return combinations;
    }


    private static final String[] letters = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinationsNotFinished(String digits) { // Not fully satisfy all test cases
        if (digits.equals("")) {
            return Collections.emptyList();
        }
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 1) {
            for (int i = 0; i < letters.length; i++) {
                if (Integer.parseInt(String.valueOf(digits.charAt(0))) == i) {
                    for (char letter : letters[i].toCharArray()) {
                        combinations.add(String.valueOf(letter));
                    }
                }
            }
            return combinations;
        }

        //StringBuilder builder = new StringBuilder();
        List<String> selectedPhoneNum = new ArrayList<>();
        String saved = "";
        int remembered = -1;
        for (int i = 0; i < digits.length(); i++) {
            for (int j = 0; j < letters.length; j++) {
                if (Integer.parseInt(String.valueOf(digits.charAt(i))) == i) {
                    if (saved.isEmpty()) {
                        saved = letters[j];
                        if (remembered == -1) {
                            remembered = i;
                        }
                    }
                    if (remembered != i || !saved.equals(letters[j])) {
                        //builder.append(combineTwoString(saved, letters[j]));
                        selectedPhoneNum.add(letters[j]);
                        saved = "";
                        remembered = 0;
                    }
                    break;
                }
            }
        }
        /*
        for (int i = 0; i < builder.length(); i = i + digits.length()) {
            combinations.add(builder.substring(i, i + digits.length()));
        }
        */
        return combinations;
    }

    //abc abc
    //[aa, ab, ac, ba, bb, bc, ca, cb, cc]
    private static String combineStringsNew(String... strings) {
        int calculatedLength = 1;
        for (String str : strings) {
            calculatedLength *= str.length();
        }

        String[] elo = new String[calculatedLength];
        int index = 0;
        String strNG = strings[0];
        for (int i = 0; i < strNG.length(); i++) {
            final int length = calculatedLength / strNG.length();
            for (int j = 0; j < length; j++) {
                if (elo[index] == null) {
                    elo[index] = "";
                }
                elo[index] = elo[index].concat(String.valueOf(strNG.charAt(i)));
                index++;
            }
        }

        index = 0;
        //List<String> elements = new ArrayList<>();

        if (strings.length > 1) {
            for (int j = 0; j < strings.length; j++) {
                final int length = calculatedLength / strings[j].length();
                for (int i = 0; i < length; i++) {
                    elo[index] = elo[index].concat(String.valueOf(strings[i].charAt(i)));
                    index++;
                }
                index = 0;
            }
        }

        System.out.println("calculatedLength = " + calculatedLength);
        return "";
    }

    //abc abc
    //[aa, ab, ac, ba, bb, bc, ca, cb, cc]
    private static String combineStringsNotFinished(String... strings) { //NotFinished
        StringBuilder stringBuilder = new StringBuilder();
        int maxLength = 0;

        // Find the maximum length among them
        for (String str : strings) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }

        // Combining the strings
        for (int i = 0; i < maxLength; i++) {
            for (String str : strings) {
                if (i < str.length()) {
                    for (int j = 0; j < maxLength; j++) {
                        stringBuilder.append(str.charAt(i)).append(str.charAt(j));
                       /*
                        for (int j = 0; j < maxLength; j++) {
                            stringBuilder.append(b.charAt(j));
                        }
                        for (String str2 : strings) {
                            if (str2.charAt(i) != c) {
                                for (int j = 0; j < str2.length(); j++) {
                                    stringBuilder.append(str2.charAt(j));
                                }
                            }
                        }
                      */
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    private static List<String> combineStringsBacktracking(String str) {
        int calculatedLength = 9;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            final int length = calculatedLength / str.length();
            for (int j = 0; j < length; j++) {
                list.add(String.valueOf(str.charAt(i)));
            }
        }
        return list;
    }
}
