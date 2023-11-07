package com.codekata.hackerrank;


import java.util.Scanner;

class JavaStringReverse{
    //Problem: https://www.hackerrank.com/challenges/java-string-reverse/problem

    public static void main(String[] args) {
        int palidrome = 0;
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String a[]= A.split("");
        for(int i = 1; i <a.length; i++){
            if(a[i].equals(a[a.length-i])){}else{palidrome++;}
        }
        if(palidrome!=0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }
}