package com.codekata.hackerrank.daysofcode.second10.day18;


import java.util.*;

public class Day18 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a new object:
        Day18 p = new Day18();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length / 2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println("The word, " + input + ", is "
                + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
    }


    LinkedList<Character> queue = new LinkedList<>();
    LinkedList<Character> stack = new LinkedList<>();

    private char dequeueCharacter() {
        return queue.remove();
    }

    private void enqueueCharacter(char c) {
        queue.add(c);
    }

    private char popCharacter() {
        return stack.pop();
    }

    private void pushCharacter(char c) {
        stack.push(c);
    }
}