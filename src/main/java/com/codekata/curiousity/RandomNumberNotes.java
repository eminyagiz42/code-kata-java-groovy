package com.codekata.curiousity;

import java.util.Random;

public class RandomNumberNotes {

    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(5) + 1;
        System.out.println(number);
        // possible numbers 1,2,3,4,5

        /*
        it's a library for generate fake data
        Faker faker = new Faker();
        faker.random().nextInt(1,6);
        //possible numbers 1,2,3,4,5
         */
    }
}
