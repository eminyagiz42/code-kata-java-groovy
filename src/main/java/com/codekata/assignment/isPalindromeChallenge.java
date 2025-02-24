package com.codekata.assignment;

import java.util.LinkedList;

public class isPalindromeChallenge {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A war at Tarawa!")); // expected output: true
        System.out.println(isPalindrome("Noel - sees Leon")); // expected output: true
        System.out.println(isPalindrome("This is not a Palindrome")); // expected output: false
    }

    public static String isPalindrome(String str) {
        // Punctuations and space are removed in the word
        char[] s = str.replaceAll("[^a-zA-Z ]", "")
                .replaceAll(" ", "").toLowerCase().toCharArray();

        LinkedList<Character> queue = new LinkedList<>();
        LinkedList<Character> stack = new LinkedList<>();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            stack.push(c);
            queue.add(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length / 2; i++) {
            if (stack.pop() != queue.remove()) {
                isPalindrome = false;
                break;
            }
        }

        return String.valueOf(isPalindrome);
    }

}
