package com.codekata.hackerrank.java;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

// This import is missing
import static java.lang.System.in;


class Prime {

    //https://www.hackerrank.com/challenges/prime-checker/problem

    public void checkPrime(int... nums) {
        for (int num : nums) {
            if (num != 1 && isPrime(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public static boolean isPrime(int number) {
        for (int i = number / 2; i > 1; i--) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void checkPrimeSolutionTwo(int... nums) { // This is solution less readable.
        for (int num : nums) {                       //So, I provided the solution above.
            int numOfDivisor = 0;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    numOfDivisor++;
                }
            }
            if (numOfDivisor == 0 && num != 1) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}

public class CheckPrimeProblem {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = 2; //Integer.parseInt(br.readLine());
            int n2 = 1; //Integer.parseInt(br.readLine());
            int n3 = 3; //Integer.parseInt(br.readLine());
            int n4 = 4; //Integer.parseInt(br.readLine());
            int n5 = 5; //Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            // ob.checkPrime(n1);
            // ob.checkPrime(n1, n2);
            // ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}