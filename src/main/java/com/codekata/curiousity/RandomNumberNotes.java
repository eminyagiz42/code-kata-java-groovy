package com.codekata.curiousity;

import net.datafaker.Faker;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberNotes {

    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(5) + 1;
        //System.out.println(number);
        // possible numbers 1,2,3,4,5

        //it's a library for generate fake data
        Faker faker = new Faker();
        final int nextInt = faker.random().nextInt(1, 6);//possible numbers 1,2,3,4,5,6
        System.out.println(nextInt);

        final Set<Integer> uniqueRandomNumbers = getRandomNumbers(3, 10);
        System.out.println(uniqueRandomNumbers);//possible numbers 1,2,3,4,5,6,7,8,9,10
    }

    public static Set<Integer> getRandomNumbers(int size, int maxRange) {
        Faker faker = new Faker();
        Set<Integer> randomNumbers = new LinkedHashSet<>();
        while (randomNumbers.size() != size) {
            randomNumbers.add(faker.random().nextInt(1, maxRange));
        }
        return randomNumbers;
    }
}
