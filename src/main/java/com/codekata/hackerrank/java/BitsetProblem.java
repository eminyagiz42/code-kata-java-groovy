package com.codekata.hackerrank.java;

import java.util.BitSet;
import java.util.Scanner;

public class BitsetProblem {

    //https://www.hackerrank.com/challenges/java-bitset/problem

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int n = s.nextInt();
        int m = s.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        for (int i = 0; i < m; i++) {
            processBitSet(b1, b2);
            System.out.println(b1.cardinality() + " " + b2.cardinality());
            if (s.hasNextLine()) {
                s.nextLine();
            }
        }
    }

    private static void processBitSet(BitSet bitOne, BitSet bitTwo) {
        final String event = s.next();
        final int number = s.nextInt();
        switch (event.charAt(0)) {
            case 'A': // AND
                if (number == 1) {
                    bitOne.and(bitTwo);
                } else {
                    bitTwo.and(bitOne);
                }
                break;
            case 'O': // OR
                if (number == 1) {
                    bitOne.or(bitTwo);
                } else {
                    bitTwo.or(bitOne);
                }
                break;
            case 'X': //XOR
                if (number == 1) {
                    bitOne.xor(bitTwo);
                } else {
                    bitTwo.xor(bitOne);
                }
                break;
            case 'F': //FLIP
                if (number == 1) {
                    bitOne.flip(number);
                } else {
                    bitTwo.flip(number);
                }
                break;
            case 'S': // SET
                if (number == 1) {
                    bitOne.set(number);
                } else {
                    bitTwo.set(number);
                }
                break;
        }
    }
}

/*
Input:
5 4
AND 1 2
SET 1 4
FLIP 2 2
OR 2 1

Output:
0 0
1 0
1 1
1 2

 */