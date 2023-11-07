package com.codekata.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InsertDeleteElementInList {
	
	//hacker rank problem : https://www.hackerrank.com/challenges/java-list/problem

	public static void main(String[] args) {
		List<Integer> numberList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int arraySize = scan.nextInt();
        for (int i = 0; i < arraySize ; i++) {
            numberList.add(scan.nextInt());
        }   
        int processNumber = scan.nextInt();
          for (int i = 0; i < processNumber; i++) {
            numberList = updateRecords(numberList, scan);
        }   
        
        for (Integer elements : numberList) {
          System.out.print(elements + " ");  
        }
     
    }
    
    public static List<Integer> updateRecords(List<Integer> numberList, Scanner scan) {
        String process = scan.next();
        if("Insert".equals(process)){
            int targetIndex = scan.nextInt();
            int targetValue = scan.nextInt();
            numberList.add(targetIndex, targetValue);
        } else if ("Delete".equals(process)){
            int targetIndex = scan.nextInt();
            numberList.remove(targetIndex);
        }
        return numberList;
    } 

}
