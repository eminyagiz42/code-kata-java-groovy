package com.codekata.hackerrank.java;

import java.util.Scanner;
import java.util.regex.*;

/**
 * The type Pattern syntax checker.
 */
class PatternSyntaxChecker{

    //Problem: https://www.hackerrank.com/challenges/pattern-syntax-checker/problem

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();
            testCases--;
            try{
                Pattern  p = Pattern.compile(pattern);
                System.out.println("VALID");
            }catch (Exception ex){
                System.out.println("INVALID");
            }
        }
    }
}


