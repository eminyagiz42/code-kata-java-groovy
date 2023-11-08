package com.codekata.leetcode75.first25;

/**
 * The type String compression.
 */
class StringCompression {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

		// https://leetcode.com/problems/string-compression/

		//char[] res = {'a','a','b','b','c','c','c'};
		//char[] res = {'a','b','b','b','b','b','b','b','b','b','b','b'};
		char[] res = {'a','a','a','b','b','a','a'};
		System.out.println(compress(res));
	}

    /**
     * Compress int.
     *
     * @param chars the chars
     * @return the int
     */
    public static int compress(char[] chars) {
		int length = 0;
		int index = 0;
		int position = 0;
		while (position < chars.length) {
			index = position + 1;
			while (index < chars.length && chars[index] == chars[position]) {
				++index;
			}
			chars[length++] = chars[position];
			if (index - position > 1) {
				for (char character : String.valueOf(index - position).toCharArray()) {
					chars[length++] = character;
				}
			}
			position = index;
		}
		return length;
	}
}