package com.codekata.leetcode.interview75.first25;

import java.util.ArrayList;

/**
 * The type Merge alternately.
 */
public class MergeAlternately {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

    	//https://leetcode.com/problems/merge-strings-alternately/

		String word1 = "  a   b   c";
		String word2 = "    p   q   r";
		
		System.out.print(mergeAlternately(word1, word2));

	}

    /**
     * Merge alternately string.
     *
     * @param word1 the word 1
     * @param word2 the word 2
     * @return the string
     */
    public static String mergeAlternately(String word1, String word2) {

	        char[] inputChars1 =  word1.toCharArray();
	        char[] inputChars2 =  word2.toCharArray();

	        ArrayList newArr = new ArrayList<>();
	        
	        
	        int arrSize = inputChars1.length > inputChars2.length ?  
	        		inputChars1.length : inputChars2.length;
	       
	        for(int i = 0; i< arrSize; i++){
	        	 if (i< inputChars1.length) {
	        		 newArr.add(inputChars1[i] );
				}
	            	             if (i< inputChars2.length) {
	            	 newArr.add(inputChars2[i]);
				}
	        }

	        return newArr.toString().replace("]", "").replace("[", "")
	           		.replaceAll(",", "").replace(" ", "");
	    }

}
