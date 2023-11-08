package com.codekata.curiousity.fundamental;

import java.util.Random;

/**
 * The type Random number notes.
 */
public class RandomNumberNotes {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            final int randomNumber = random.nextInt(10);  // starts from 0 & less than 10
            System.out.println(i + " randomNumber = " + randomNumber);
        }

        /* This output will be changed every run
        0 randomNumber = 5
        1 randomNumber = 2
        2 randomNumber = 5
        3 randomNumber = 3
        4 randomNumber = 8
        5 randomNumber = 5
        6 randomNumber = 4
        7 randomNumber = 6
        8 randomNumber = 2
        9 randomNumber = 0
        */
    }
}
