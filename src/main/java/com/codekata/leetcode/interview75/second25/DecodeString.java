package com.codekata.leetcode.interview75.second25;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Decode string.
 */
public class DecodeString {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        // https://leetcode.com/problems/decode-string

        String str1 = "3[a]2[bc]";
        String str2 = "2[abc]3[cd]ef";
        String str3 = "3[a2[c]]"; // accaccacc
        String str4 = "a2[c]"; // acc
        String str5 = "a2[c]b"; // accb
        String str6 = "abc3[cd]xyz"; // abccdcdcdxyz
        String str = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef"; //zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
        System.out.println(decodeString(str));
    }

    /**
     * Decode string string.
     *
     * @param s the s
     * @return the string
     */
    public static String decodeString(String s) { // 5ms
        String res = "";
        Stack<Integer> nums = new Stack<Integer>();
        Stack<String> strs = new Stack<String>();
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                cnt = 10 * cnt + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                nums.push(cnt);
                strs.push(res);
                cnt = 0; res = "";
            } else if (s.charAt(i) == ']') {
                int k = nums.pop();
                String next = strs.pop();
                for (int j = 0; j < k; ++j)
                    next += res;
                res = next;
            } else {
                res += s.charAt(i);
            }
        }
        return res;
    }

    private static final Pattern ONLY_DECIMAL = Pattern.compile("\\d+");
    //private static final String SPLIT_BRACKET_KEEP_DELIMITER = "((?<=]))";

    /**
     * Decode string 1 string.
     *
     * @param s the s
     * @return the string
     */
//TODO Handle the extreme case: "3[z]2[2[y]pq4[2[jk]e1[f]]]ef"
    // expected output zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
    public static String decodeString1(String s) {
        String SPLIT_BRACKET_KEEP_DELIMITER = "((?<=]))";
        if (s.contains("]]")) {
            SPLIT_BRACKET_KEEP_DELIMITER = "((?<=]]))";
        }
        StringBuilder stringBuilder = new StringBuilder();
        final String[] splited = s.split(SPLIT_BRACKET_KEEP_DELIMITER);
        for (final String text : splited) {
            if (hasNumber(text)) {
                stringBuilder.append(substringAppend(text));
            } else {
                stringBuilder.append(text);
            }
        }
        return stringBuilder.toString();
    }

    private static String substringAppend(String str) {
        final String longBracket = str.substring(str.indexOf('[') + 1, str.lastIndexOf(']'));
        final String innerBracket = str.substring(str.lastIndexOf('[') + 1, str.indexOf(']'));
        if (!innerBracket.isEmpty() && !longBracket.equals(innerBracket) ) {
            final String prepared = prepareAndMultiply(longBracket, innerBracket);
            String result = str.replace(longBracket, prepared);
            if (hasNumber(result)) {
                return prepareAndMultiply(result, prepared);
            }
        }
        return prepareAndMultiply(str, longBracket);
    }

    private static String prepareAndMultiply(String str, String longBracket) {
        StringBuilder builder = new StringBuilder();
        final String preBracket = str.substring(0, str.indexOf('['));
        String preNumber = preBracket;
        if (hasAlphabetic(preBracket)) {
            final String[] split = preBracket.split("");
            for (String p : split) {
                if (p.equals( split[split.length-1])) {
                    preNumber = p;
                } else {
                    builder.append(p);
                }
            }

        }
        builder.append(multiplyBrackets(preNumber, longBracket));
        if (str.contains("]") ) {
            final String postBracket = str.substring(str.lastIndexOf(']') + 1);
            builder.append(postBracket);
        }
        return builder.toString();
    }

    private static boolean hasAlphabetic(String s) {
        if (s == null) {
            return false;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if ((Character.isLetter(s.charAt(i)))) {
                return true;
            }
        }
        return false;

    }

    private static boolean hasNumber(String text) {
        final Matcher decimals = ONLY_DECIMAL.matcher(text);
        return decimals.find();
    }

    private static String multiplyBrackets(String number, String brackets) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(number); i++) {
            builder.append(brackets);
        }
        return builder.toString();
    }


    /**
     * This approach didn't satisfied me,
     * So, I started from the scratch.
     *
     * @param s the s
     * @return the string
     */
    public static String decodeString2(String s) {
        List<String> analyzedList = getAnalyzedList(s);
        String result = multiplyBrackets(analyzedList.get(0), analyzedList.get(1));
        while (hasNumber(result)) {
            decodeString(result);
        }
        return result;
    }

    private static List<String> getAnalyzedList(String s) {
        List<String> analyzedList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        final char[] charArray = s.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '[') {
                while (charArray[i] != ']') {
                    if (charArray[i] == '[') {
                        count++;
                    }
                    builder.append(charArray[i++]);
                }
                for (int j = 0; j < count; j++) {
                    builder.append("]");
                }
                analyzedList.add(builder.toString());
                builder = new StringBuilder();
            } else {
                analyzedList.add(Character.toString(charArray[i]));
            }
        }
        return analyzedList;
    }

    private static final Pattern INSIDE_BRACKET = Pattern.compile("(?<=\\[).+?(?=\\]$)");

    /**
     * I can't solve some exceptional cases
     */
    private static String multiplyStringStandard(String s) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        List<Integer> decimalsList = new ArrayList<>();
        final Matcher decimals = ONLY_DECIMAL.matcher(s);
        while (decimals.find()) {
            decimalsList.add(Integer.parseInt(decimals.group()));
        }
        //   String temp = s;
        //  builder.append(temp.replaceAll("\\[.*?\\]", "").replaceAll("[0-9]",""));
        final Matcher letters = INSIDE_BRACKET.matcher(s);
        while (letters.find()) {
            Integer current = decimalsList.get(index++);
            while (current > 0) {
                builder.append(letters.group());
                current--;
            }
        }
        return builder.toString();
    }
}