package com.codekata.hackerrank.java;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Tag content practice.
 */
public class TagContentExtractor {

	public static final String REGEX_FOR_TAG = "<(.+)>([^<]+)</\\1>";

	/**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){

    	//https://www.hackerrank.com/challenges/tag-content-extractor/

		String a = "<h1>Nayeem loves counseling</h1>";
		String b= "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
		String c = "<Amee>safat codes like a ninja</amee>";		
		String d = "<SA premium>Imtiaz has a secret crush</SA premium>";

		String a1 = "<h1>some</h1>";
		String a2 = "<h1>had<h1>public</h1></h1>";
		String a3 = "<h1>had<h1>public</h1515></h1>";
		String a4 = "<h1><h1></h1></h1>";
		String a5 = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<";
		String a6 = ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";
		String a7 = "<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>";
		String a8 = "<>hello</>";
		String a9 = "<>hello</><h>dim</h>";
		String a10 = "<>hello</><h>dim</h>>>>>";
		
	
		String[] asd = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10};
		
		for(String x : asd) {
			printWithoutTag(x);
		}
	}

	public static void printWithoutTag(String textWithTag) {
		boolean matchFound = false;
		Pattern pattern = Pattern.compile(REGEX_FOR_TAG);
		Matcher matcher = pattern.matcher(textWithTag);
		while (matcher.find()) {
			System.out.println(matcher.group(2));
			matchFound = true;
		}
		if (!matchFound) {
			System.out.println("None");
		}
	}

    /**
     * Print without tag.
     *
     * @param textWithTag the text with tag
     */
    public static void printWithoutTag2(String textWithTag ) {
		
		String text = textWithTag.replaceAll("<","").replaceAll(">","").replaceAll("/","");
		if(text.isEmpty()) {
			System.out.println("None");
		}else {
			List<String> selectedTag = new ArrayList();
			int i = textWithTag.indexOf("</");
			String[] a =  {textWithTag.substring(0, i), textWithTag.substring(i)};
			for(String t : a) {
				int x = t.lastIndexOf(">");
				String[] y =  {t.substring(0, x), t.substring(x)};
				for(String m : y) {
					System.out.println(m);
				}
				//System.out.println(y[y.length-1]);
			}
			/*
			String[] star = textWithTag.split("<[^<>]+>");
			for(String t : star) {
				if(!t.isBlank()) {
					if(t.contains("<") || t.contains("<")) {
						System.out.println("None");
					} else {
						System.out.println(t);
					}
				}
			}
		*/
			
			//String[] star = textWithTag.split("<.?.>*");
			//String[] end = textWithTag.split("<\\//(.)>");
			
			//System.out.print(star[0] + " = ");
			//System.out.println(end[0]);
			/*
		String[] startArr = textWithTag.split(">");		
		String[] endArr = textWithTag.split("</");
		
		if(endArr != null && startArr != null && endArr.length >= 1 ) {
			String endTag = endArr[1].replace(">", "");
			String startTag = startArr[0].replace("<", "");	
			
			if(startTag.equals(endTag)) {
				String[] x = textWithTag.trim().split("<(.+?)>");
		
				List<String> asd = Arrays.asList(x);
			
				
				   ArrayList<String> arr_new = new ArrayList<String>();
			        for (String i : asd){
			        	if(i != "") {
			        		arr_new.remove("");
			        	}
			            arr_new.add(i);
			        }
			        
			
			        for (String ba : arr_new){
						System.out.println(ba);
				}
				
			} else {
				System.out.println("None");
			}
		}else {
			System.out.println("None");
		}
	*/
		}
		
	}
}


