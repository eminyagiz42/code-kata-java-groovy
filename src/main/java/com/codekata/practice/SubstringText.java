package com.codekata.practice;

import java.net.URI;

public class SubstringText {

	public static void main(String[] args) {
		
		String txt = "https://d.e.v/rest/catalog/attributes?page[limit]=10000&page[offset]=3333";
		String txt2 = "https://d.e.v/rest/catalog/attributes?page[offset]=3333&page[limit]=10000";

		String queryString  = URI.create(txt).getQuery();
		String queryString2 = URI.create(txt2).getQuery();
	   
	    String subString =  queryString.substring(queryString.indexOf("[offset]=") +9, queryString.indexOf("[offset]=") + 13);
	    String subString2 =  queryString2.substring(queryString2.indexOf("[offset]=") +9, queryString2.indexOf("[offset]=") + 13);
	    
	    System.out.println("EXTRACTED1 " + subString);
	    System.out.println("EXTRACTED2 " + subString2);
		
	}

}
