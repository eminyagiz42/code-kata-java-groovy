package com.codekata.leetcode;

import java.util.Stack;

public class IsSubsequence {

    public static void main(String[] args) {

        // https://leetcode.com/problems/is-subsequence

        //String s1 = "acb", t1 = "ahbgdc"; // false
        String s2 = "abc", t2 = "ahbgdc"; // true
        String s3 = "aaaaaa", t3 = "bbaaaa"; // false
        String s4 = "axc", t4 = "ahbgdc"; // false
        //System.out.println(isSubsequence(s1, t1));
        System.out.println(isSubsequence(s2, t2));
        System.out.println(isSubsequence(s3, t3));
        System.out.println(isSubsequence(s4, t4));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        int count1 = 0;
        int count2 = 0;
        String[] words1 = t.split("");
        String[] words2 = s.split("");
        for (String one : words1) {
            for (String two : words2) {
                if (two.equals(one)) {
                    count1++;
                }
                count2++;
            }
        }
        return count1 == s.length();

        /*int i = 0, j = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();

         */
    }

    public static boolean isSubsequence0(String s, String t) {//0ms
        int subStrIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            subStrIndex = t.indexOf(currChar);
            if (subStrIndex == -1) {
                return false;
            } else {
                t = t.substring(subStrIndex + 1);
            }
        }
        return true;
    }

    public static boolean isSubsequence1(String s, String t) { //1ms
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }


    public boolean isSubsequence2(String s, String t) { //2ms
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stack.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == stack.lastElement()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubsequence3(String s, String t) { //3ms
        Integer leftBound = s.length();
        Integer rightBound = t.length();
        Integer pLeft = 0;
        Integer pRight = 0;
        while (pLeft < leftBound && pRight < rightBound) {
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft += 1;
            }
            pRight += 1;
        }
        return pLeft == leftBound;
    }

    public boolean isSubsequenceM(String s, String t) { // Best memory 38.5mb
        int i = 0, j = 0;

        while (i < s.length() && j < t.length())
            if (s.charAt(i) == t.charAt(j++))
                i++;

        return i == s.length();
    }
}

