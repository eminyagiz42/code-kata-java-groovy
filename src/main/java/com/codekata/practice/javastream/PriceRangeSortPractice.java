package com.codekata.practice.javastream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Price range sort practice.
 */
public class PriceRangeSortPractice {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("100-200 TRY");
		arrayList.add("0-50 TRY");
		arrayList.add("200-500 TRY");
		arrayList.add("50-100 TRY");
	//	arrayList.add("0-150 TRY");
		

		Map<Integer, Integer> result = new HashMap<>();
		arrayList.forEach(a -> {
			String [] minAndMax  = a.replace(" TRY", "").split("-");
			result.put(Integer.valueOf(minAndMax[0]), Integer.valueOf(minAndMax[1]));
			});	
		
		result.entrySet().stream().sorted(Collections.reverseOrder((Map.Entry.comparingByKey())));
		 
		System.out.println(result);
	}
}
