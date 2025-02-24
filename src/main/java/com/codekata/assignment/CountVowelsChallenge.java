package com.codekata.assignment;

import java.util.Arrays;
import java.util.List;

public class CountVowelsChallenge {

    public static void main(String[] args) {
        System.out.println(countVowelsChallenge("hello")); // expected output: 2
        System.out.println(countVowelsChallenge("coderbyte"));// expected output: 3
        System.out.println(countVowelsChallenge("All cows eat grass and moo"));// expected output: 8
    }

    public static List<String> vowels = Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");

    public static String countVowelsChallenge(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(String.valueOf(str.charAt(i)))) {
                count++;
            }
        }
        return String.valueOf(count);
    }

    public static String countVowelsChallenge2(String str) {
        int vowelCount = 0;
        for (char c : str.toCharArray()) {
            c = Character.toLowerCase(c);

            if (c == 'a' || c == 'e' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }
        return Integer.toString(vowelCount);
    }
}
