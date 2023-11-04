package practice;

import java.util.ArrayList;

public class MergeAlternately {

	public static void main(String[] args) {
		
		String word1 = "  a   b   c";
		String word2 = "    p   q   r";
		
		System.out.print(mergeAlternately(word1, word2));

	}
	
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
