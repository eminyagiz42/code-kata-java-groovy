package com.codekata.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Reverse sum node.
 */
public class ReverseSumNode {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Integer[] l1 = {2,4,3};
        Integer[] l2 = {5,6,4};      
        
        final List<String> values = new ArrayList<String>();
        
        
        for (int i = 0; i < l2.length; i++) {
        	int sum = l1[i] + l2[i];
        	if(sum >= 10) {
        		sum = sum-10;
        		l1[i+1]++;
        	}
        	values.add(String.valueOf(sum));
		}

        String result = Arrays.toString(values.toArray());
        StringBuilder stringBuildervarible = new StringBuilder();
        String onlyNumber = result.replace("]", "").replace("[", "")
        		.replaceAll(",", "").replace(" ", "").trim();
        
        stringBuildervarible.append(onlyNumber);
        stringBuildervarible.reverse();
     
       System.out.println(stringBuildervarible);
       

	}

}
