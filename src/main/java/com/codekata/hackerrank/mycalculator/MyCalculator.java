package com.codekata.hackerrank.mycalculator;


class MyCalculator implements AdvancedArithmetic {

    public int divisor_sum(int n) {
        int sum = 0;
        for (int i = n; i > 0; i--) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}


