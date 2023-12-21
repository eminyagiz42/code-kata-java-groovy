package com.codekata.hackerrank.java;

import java.io.*;
import java.util.*;

public class LambdaProblem {

    // https://www.hackerrank.com/challenges/java-lambda-expressions/

    public static void main(String[] args) throws IOException {
        MyMath math = new MyMath();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            PerformOperation operation;
            boolean ret;
            String ans = null;
            while (T-- > 0) {
                String s = br.readLine().trim();
                StringTokenizer st = new StringTokenizer(s);
                int ch = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                if (ch == 1) {
                    operation = math.isOdd();
                    ret = math.checker(operation, num);
                    ans = (ret) ? "ODD" : "EVEN";
                } else if (ch == 2) {
                    operation = math.isPrime();
                    ret = math.checker(operation, num);
                    ans = (ret) ? "PRIME" : "COMPOSITE";
                } else if (ch == 3) {
                    operation = math.isPalindrome();
                    ret = math.checker(operation, num);
                    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

                }
                System.out.println(ans);
            }

        }
    }
}

interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    PerformOperation isPrime() {
        return (int a) ->
        {
            if (a != 1) {
                for (int i = 2; i < Math.sqrt(a); i++) {
                    if (a % i == 0) {
                        return false;
                    }
                }
            }
            return true;
        };
    }

    PerformOperation isPalindrome() {
        return (int a) ->
        {
            String str = Integer.toString(a);
            String reverse = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                reverse = reverse + str.charAt(i);
            }
            return reverse.equals(str);
        };
    }
}
