package com.codekata.leetcode.interview75.third25;

public class BitMinFlips {

    public static void main(String[] args) {
        // https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c

        int a = 2, b = 6, c = 5; // output: 3
        System.out.println(minFlips(a, b, c));
    }

    public static int minFlips(int a, int b, int c) {
        final int kMaxBit = 30;
        int flipCount = 0;

        for (int i = 0; i < kMaxBit; ++i) {
            if ((c >> i & 1) == 1){
                if((a >> i & 1) == 0 && (b >> i & 1) == 0) {
                    flipCount += 1;
                } else {
                    flipCount += 0;
                }
            } else {
                if((a >> i & 1) == 1) {
                    flipCount += 1;
                } else {
                    flipCount += 0;
                }
                if((b >> i & 1) == 1 ) {
                    flipCount += 1;
                } else {
                    flipCount += 0;
                }
            }
        }
        return flipCount;
    }

    public static int minFlipsNotFinished(int a, int b, int c) {

        String binaryA = Integer.toBinaryString(a);
        String binaryB = Integer.toBinaryString(b);
        String binaryC = Integer.toBinaryString(c);

        int maxLen = Math.max(Math.max(binaryA.length(), binaryB.length()), binaryC.length());
        binaryA = String.format("%" + maxLen + "s", binaryA).replace(' ', '0');
        binaryB = String.format("%" + maxLen + "s", binaryB).replace(' ', '0');
        binaryC = String.format("%" + maxLen + "s", binaryC).replace(' ', '0');

        int flips = 0;
        for (int i = 0; i < maxLen; i++) {
            int bitA = Character.getNumericValue(binaryA.charAt(i));
            int bitB = Character.getNumericValue(binaryB.charAt(i));
            int bitC = Character.getNumericValue(binaryC.charAt(i));

            if ((bitA | bitB) != bitC && (bitA & bitB) != bitC) {
                flips++;
            }
        }
        return flips;
    }

}
