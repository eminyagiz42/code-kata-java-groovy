package com.codekata.hackerrank.daysofcode.day8;

import java.util.*;
import java.io.*;

class Day8 {

    //https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<String, Integer> phoneBook = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
//            phoneBook.put("harry", 12299933);
//            phoneBook.put("tom", 11122222);
//            phoneBook.put("sam", 99912222);
        }
        while (in.hasNext()) {
            String s = in.next();
            if (phoneBook.get(s) == null) {
                System.out.println("Not found");
            } else {
                System.out.println(s + "=" + phoneBook.get(s));
            }
        }
        in.close();
    }
}


//No need for loop: it exceeds time, instead of this, we get by key value
//            for (Map.Entry<String, Integer> s1 : phoneBook.entrySet()) {
//                if (s.equals(s1.getKey())) {
//                    found = s1.getKey() +"="+ s1.getValue();
//                }
//            }
//            System.out.println(found);