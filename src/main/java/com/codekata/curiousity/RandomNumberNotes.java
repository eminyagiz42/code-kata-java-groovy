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

        final Set<Integer> uniqueRandomNumbers = getUniqueRandomNumbers(10);
        System.out.println(uniqueRandomNumbers);
    }

    public static Set<Integer> getUniqueRandomNumbers(int howMany) {
        Faker faker = new Faker();
        Set<Integer> randomNumbers = new LinkedHashSet<>();
        while (randomNumbers.size() != howMany) {
            randomNumbers.add(faker.random().nextInt(1, 10)); //Range 1 and 10 inclusive
            //randomNumbers.add(faker.random().nextInt(10)); //Range 0 inclusive, 10 exclusive
        }
        return randomNumbers;
    }
}
