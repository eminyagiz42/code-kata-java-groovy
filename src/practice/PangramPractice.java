package practice;

import util.Constant;

import java.util.HashSet;

public class PangramPractice {

    public static final int NUMBER_OF_LETTERS_IN_ALPHABET = 26;

    public static void main(String[] args) {

        //Pangram means, it is a sentence that contains all letters in alphabet.
        String str = "The five boxing wizards jump quickly."; // yes

        long start = System.currentTimeMillis();
        if (hasAllAlphabetLetter(Constant.VERY_LONG_SENTENCE)) {
            System.out.println("yes, it is pangram sentence!");
        } else {
            System.out.println("no, it is not ");
        }
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("timeElapsed = " + timeElapsed);
    }

    private static boolean hasAllAlphabetLetterMy(String str) { //147ms author: EminYagiz
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && Character.isAlphabetic(str.charAt(i))) {
                hashSet.add(str.toLowerCase().charAt(i));
            }
        }
        return hashSet.size() == NUMBER_OF_LETTERS_IN_ALPHABET;
    }

    private static boolean hasAllAlphabetLetterAlexLee(String str) { //0ms author: AlexLee
        boolean[] mark = new boolean[26];
        boolean pangram = true;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current >= 'A' && current <= 'Z') {
                index = current - 'A';
            } else if (current >= 'a' && current <= 'z') {
                index = current - 'a';
            }
            mark[index] = true;
        }
        for (boolean bool : mark) {
            if (!bool) {
                pangram = false;
            }
        }
        return pangram;
    }

    public static boolean hasAllAlphabetLetter(String str) { // 0ms  author: GeeksForGeeks
        final int len = str.length();
        str = str.toLowerCase();
        boolean[] present = new boolean[NUMBER_OF_LETTERS_IN_ALPHABET];
        for (int i = 0; i < len; i++) {
            if (Character.isLetter((str.charAt(i)))) {
                int letter = str.charAt(i) - 'a';
                present[letter] = true;
            }
        }
        for (int i = 0; i < NUMBER_OF_LETTERS_IN_ALPHABET; i++) {
            if (!present[i])
                return false;
        }
        return true;
    }
}
