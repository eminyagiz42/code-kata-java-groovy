package com.codekata.leetcode.interview75.first25;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type Close strings.
 */
public class CloseStrings {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //https://leetcode.com/problems/determine-if-two-strings-are-close/
        String word1 = "abc", word2 = "bca";
        //String word1 = "cabbba", word2 = "abbccc";
        //String word1 = "abbzzca", word2 = "babzzcz";
        //String word1 = "aaabbbbccddeeeeefffff", word2 = "aaaaabbcccdddeeeeffff";
        //String word1 = "cabbba", word2 = "aabbss";
        System.out.println(closeStrings(word1, word2));
    }

    // Quick solution
    private static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] cc1 = new int[26];
        int[] cc2 = new int[26];
        for (int i=0; i<word1.length(); i++) {
            cc1[word1.charAt(i)-'a']++;
            cc2[word2.charAt(i)-'a']++;
        }
        for (int i=0; i<26; i++) {
            if ((cc1[i] == 0) != (cc2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(cc1);
        Arrays.sort(cc2);
        for (int i=0; i<26; i++){
            if (cc1[i] != cc2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Close strings with bug boolean.
     *
     * @param word1 the word 1
     * @param word2 the word 2
     * @return the boolean
     */
//TODO 149 / 153 testcases passed, fix the bug later
    public static boolean closeStringsWithBug(String word1, String word2) {
        final Map<Character, Integer> charMap1 = countElements(word1.toCharArray());
        final Map<Character, Integer> charMap2 = countElements(word2.toCharArray());
        int countK = 0;
        int countV = 0;
        for (Map.Entry<Character, Integer> e : charMap1.entrySet()) {
            if (charMap2.containsKey(e.getKey())) {
                countK++;
            }
            if (charMap2.containsValue(e.getValue())) {
                countV++;
            }
        }

        return countV == countK && charMap1.size() == countV;
    }

    /**
     * Close strings ideas boolean.
     *
     * @param word1 the word 1
     * @param word2 the word 2
     * @return the boolean
     */
    public static boolean closeStringsIdeas(String word1, String word2) {
        final Map<Character, Integer> charMap1 = countElements(word1.toCharArray());
        final Map<Character, Integer> charMap2 = countElements(word2.toCharArray());
        return countOccurrences(charMap2, charMap1) && countOccurrences(charMap1, charMap2);
    }

    private static boolean countOccurrences(Map<Character, Integer> charMap1, Map<Character, Integer> charMap2) {
        int countK = 0;
        //int countV = 0;
        int numberOfDuplicate = 0;

        for (Map.Entry<Character, Integer> entry1 : charMap1.entrySet()) {
            Character key1 = entry1.getKey();
            Integer value1 = entry1.getValue();

            for (Map.Entry<Character, Integer> entry2 : charMap2.entrySet()) {
                Character key2 = entry2.getKey();
                Integer value2 = entry2.getValue();

                if (value1 == value2 && key1 == key2) {
                    System.out.println(key1 + " and " + value1 + " " + key2 + " and " + value2  );
                }
                break;
            }
        }

        /*
        for (Map.Entry<Character, Integer> one : charMap1.entrySet()) {
            if (charMap1.containsKey(one.getKey())) {
                countK++;
            }
            final Integer two = charMap2.get(one.getKey());


            if (one.getKey().equals(two) && one.getValue().equals(two.getValue())) {
                numberOfDuplicate++;
            }
        }
         */
       //  Set<Integer> values1 = new HashSet<>(charMap1.values());
       // Set<Integer> values2 = new HashSet<>(charMap2.values());
       // return countV == countK && charMap1.size() == countV && values1.size() == values2.size();
        return charMap1.size() == countK && charMap1.size() == numberOfDuplicate + 2;
    }


    /**
     * Count elements map.
     *
     * @param array the array
     * @return the map
     */
    public static Map<Character, Integer> countElements(char[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Map<Character, Integer> elementCounts = new LinkedHashMap<>();
        for (Character currentElement : array) {
            if (elementCounts.containsKey(currentElement)) {
                elementCounts.put(currentElement, elementCounts.get(currentElement) + 1);
            } else {
                elementCounts.put(currentElement, 1);
            }
        }
        return elementCounts;
    }
}
