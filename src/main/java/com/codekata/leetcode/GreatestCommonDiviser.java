package com.codekata.leetcode;


/**
 * The type Greatest common diviser.
 */
class GreatestCommonDiviser {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        // https://leetcode.com/problems/greatest-common-divisor-of-strings/

        //System.out.println(gcdOfStrings("ABCABC", "ABC"));
		System.out.println(gcdOfStrings("ABABABAB", "ABAB"));
        System.out.println(gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
        //System.out.println(gcdOfStrings("AAAAAAAAA", "AAACCC"));
        //System.out.println(gcdOfStrings("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
        //System.out.println(gcdOfStrings("ADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBB", "ADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBB"));
    }

    /**
     * Gcd of strings string.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @return the string
     */
    public static String gcdOfStrings(String str1, String str2) {
        String shorterStr = "";
        String longerStr = "";
        if (str1.length() < str2.length()) {
            shorterStr = str1;
            longerStr = str2;
        } else {
            shorterStr = str2;
            longerStr = str1;
        }

        if (longerStr.equals(shorterStr)) {
            return shorterStr;
        }

        if (!longerStr.startsWith(shorterStr)) {
            return "";
        }

        return gcdOfStrings(longerStr.substring(shorterStr.length()), shorterStr);



        /* 2nd solution
        // TODO fix the bug about any smaller common divisor
        final String commonDivisor = findCommonDivisor(shorterStr, longerStr);

        if ("".equals(shorterStr.replaceAll(commonDivisor, "")) && "".equals(longerStr.replaceAll(commonDivisor, ""))) {
            return commonDivisor;
        }
        return "";
         */
    }


    /**
     * find the common divisor recursively
     * if it returns empty,
     * try to substring one less letter of short string
     *
     * @param shorterStr the shorter str
     * @param longerStr  the longer str
     * @return the string
     */
    public static String findCommonDivisor(String shorterStr, String longerStr) {
        String commonDivisor = isCommonDivisor(shorterStr, longerStr);
        if ("".equals(commonDivisor)) {
            if (shorterStr.length() > 1) {
                return findCommonDivisor(shorterStr.substring(0, shorterStr.length() - 1), longerStr);
            }
            return "";
        } else {
            String removedRepetitive = findCommonPrefix(commonDivisor);
            if (commonDivisor.equals(shorterStr)) {
                return commonDivisor;
            }


            if ( "".equals(longerStr.replaceAll(commonDivisor, "")) && "".equals(shorterStr.replaceAll(commonDivisor, ""))) {
                return commonDivisor;
            } else if ("".equals(longerStr.replaceAll(removedRepetitive, "")) && "".equals(shorterStr.replaceAll(removedRepetitive, ""))) {
                    return removedRepetitive;

            }
        }
        return "";
    }

    private static String isCommonDivisor(String shorterStr, String longerStr) {
        if (longerStr.contains(shorterStr)) {
            if ("".equals(longerStr.replaceAll(shorterStr, ""))) {
                return shorterStr;
            }
        }
        return "";
    }

    /**
     * Find common prefix string.
     *
     * @param input the input
     * @return the string
     */
    public static String findCommonPrefix(String input) {
        int len = input.length();
        for (int i = 1; i <= len / 2; i++) {
            String prefix = input.substring(0, i);
            if (input.matches("^(" + prefix + ")+$")) {
                return prefix;
            }
        }
        return input;
    }
}

