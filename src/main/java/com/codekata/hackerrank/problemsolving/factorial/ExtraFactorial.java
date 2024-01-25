package com.codekata.hackerrank.problemsolving.factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;


public class ExtraFactorial {

    //https://www.hackerrank.com/challenges/extra-long-factorials/problem

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        Result.extraLongFactorials(n);
        bufferedReader.close();
        */
        int n = 25; // 15511210043330985984000000
        Result.extraLongFactorials(n);
    }
}

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    public static void extraLongFactorials(int n) {
        System.out.println(factorial(BigDecimal.valueOf(n)));
    }

    public static BigDecimal factorial(BigDecimal n) {
        if (n.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        }
        return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
    }

}
