package com.codekata.hackerrank.java;

import java.util.Scanner;
import java.util.Stack;

class JavaStackProblem {

    public static final String REGEX_PATTERN = "\\(\\)|\\[\\]|\\{\\}";

    //https://www.hackerrank.com/challenges/java-stack/problem

    public static void mainJava8(String[] args) { // Java8 regex shorter version
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            while (input.length() != (input = input.replaceAll(REGEX_PATTERN, "")).length());
            System.out.println(input.isEmpty());
        }
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (isBalanced(line)) System.out.println("true");
            else System.out.println("false");
        }
    }

    public static boolean isBalanced(String s) { // 1 / 3 cases are solved
        Stack<Character> stack = new Stack<>();
        //for (int i = 0; i < s.length(); ++i) {
        for (final char c : s.toCharArray()) {
            //switch (s.charAt(i)) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if(stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}

/*

{}()
({()})
{}(
[]

 */