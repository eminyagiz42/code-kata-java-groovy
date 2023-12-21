package com.codekata.hackerrank.java;

import java.util.Scanner;

/**
 * The type Java anagrams.
 */
public class JavaAnagrams{

//Problem: https://www.hackerrank.com/challenges/java-anagrams/problem

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }

    /**
     * Is anagram boolean.
     *
     * @param a the a
     * @param b the b
     * @return the boolean
     */
    static boolean isAnagram(String a, String b) {

        boolean bool = true;

        //String to char array
        String words1[] = a.split("");
        String words2[] = b.split("");

        //To lower char all array elements
        for (int c= 0;c<words1.length;c++ ) { 
            words1[c] = words1[c].toLowerCase();    
        }

        for (int d = 0;d<words2.length;d++ ) { 
        words2[d] = words2[d].toLowerCase();
        }

        //alphabet array
        String alphabet[] = {"a", "b", "c", "d", "e", "f", "g", "h", 
        "i", "j", "k", "l", "m", "n", "o", "p","q", "r", "s", "t",
        "u", "v", "w", "x", "y", "z"};

        //frequency array
        int freq1[] = new int[alphabet.length];
        int freq2[] = new int[alphabet.length];

        // Make all values of frequency array to "0"
        for ( int e= 0;e<alphabet.length;e++ ) {
            freq1[e] = 0; 
            freq2[e] = 0;
            }

        //loop for the array contains how many number of letters
        for (int f= 0;f< alphabet.length;f++ ) {
            for (int g= 0;g< words1.length;g++ ) {
                if( alphabet[f].equals(words1[g]))
                freq1[f]++;
            }

            for (int h= 0;h< words2.length;h++ ) {
                if( alphabet[f].equals(words2[h]))
                freq2[f]++;
            }
        }

        // comparing two frequency array
        for ( int k = 0;k<alphabet.length; k++ ) {
             if( freq1[k] == freq2[k] ){}
             else{bool = false;}
        }
      
      return bool;
   
    }

}