package com.codekata.curiousity.fundamental.loop;

public class LoopPlusPlusNotes {

    public static void main(String[] args) {

        for (int i = 0; i < 5; ++i) {
            System.out.println("i = " + ++i);
        }
        /* ++i (Plus plus BEFORE means, BEFORE the line, do i = i + 1;)
                i = 1
                i = 3
                i = 5
         */

        System.out.println("");

        for (int j = 0; j < 5; j++) {
            System.out.println("j = " + j++);
        }

        /* j++ (Plus plus AFTER means, AFTER the line, do j = j + 1;)
                j = 0
                j = 2
                j = 4
         */

        System.out.println();

        // Alternatively
        for (int k = 0; k < 5; k = k + 2) {
            System.out.println("k = " +  k);
        }

        System.out.println();

        for (int l = 1; l < 5; l = l + 2) {
            System.out.println("l = " +  l);
        }

    }
}
