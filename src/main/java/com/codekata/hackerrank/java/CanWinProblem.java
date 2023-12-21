package com.codekata.hackerrank.java;


public class CanWinProblem {

    public static void main(String[] args) {
        int a = 6;
        int b = 4;
        int[] game = {0, 0, 0, 1, 1, 1};

        //int b = 3;
        //int[] game = {0, 0, 1, 1, 1, 0};

        //int[] game = {0, 0, 0, 0, 0};
        //int b = 5;
        //int[] game = {0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1,0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1}; //true

        System.out.println(canWin(b, game));
    }

    // This example fully covers the problem
    public static boolean canWin(int leap, int[] game) {
        int length = game.length;
        if (leap >= length){
            return true;
        }
        boolean[] canJumpToCell = new boolean[(length + leap)];
        canJumpToCell[0] = true;

        for (int i = 0; i < length; i++) {
            if (canJumpToCell[i]) {
                if ((i + 1) < length && game[i + 1] == 0 && !canJumpToCell[i + 1]) {
                    canJumpToCell[i + 1] = true;
                }
                if ((i + leap) >= length) {
                    return true;
                }
                if (game[i + leap] == 0) {
                    if ((i + leap) == (length - 1)) {
                        return true;
                    }
                    if (!canJumpToCell[i + leap]){
                        canJumpToCell[i + leap] = true;
                    }
                    if ((i + leap) > 0) {
                        int j = 1;
                        while ((game[i + leap - j] == 0) && (!canJumpToCell[i + leap - j])) {
                            canJumpToCell[i + leap - j] = true;
                            j++;
                        }
                    }
                }
            }
        }
        return false;
    }

    //Not completed needs backwards jump
    private static boolean canWin2(int b, int[] game) {
        int endZeros = 0;
        int startZeros = 0;
        int countOnes = 0;
        for (int i = 0; i < game.length; i++) {
            if (game[i] == 0) {
                endZeros++;
                if (i != game.length -1  && game[i+1] == 1) {
                    startZeros = endZeros;
                    endZeros = 0;
                }
            } else if (game[i] == 1){
                countOnes++;
            }
        }

        System.out.println(startZeros);
        System.out.println(countOnes);
        System.out.println(endZeros);

        return b > countOnes;
    }
}
