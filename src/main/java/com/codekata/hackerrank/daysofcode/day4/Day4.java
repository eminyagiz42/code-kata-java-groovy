package com.codekata.hackerrank.daysofcode.day4;

import java.util.Scanner;

public class Day4 {

    //https://www.hackerrank.com/challenges/30-class-vs-instance/problem

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int age = sc.nextInt();
            Person p = new Person(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
            System.out.println();
        }
        sc.close();
    }


    public static class Person {

        private int age;

        public Person(int initialAge) {
            if (initialAge < 0) {
                age = -1;
                System.out.println("Age is not valid, setting age to 0.");
            } else {
                age = initialAge;
            }
        }

        public void amIOld() {
            if (age < 13) {
                System.out.println("You are young.");
            } else if (age >= 13 && age < 18) {
                System.out.println("You are a teenager.");
            } else if (age >= 18) {
                System.out.println("You are old.");
            }
        }

        public void yearPasses() {
            age++;
        }
    }
}

/*
4
-1
10
16
18


Age is not valid, setting age to 0.
You are young.
You are young.
You are young.
You are a teenager.
You are a teenager.
You are old.
You are old.
You are old.
 */



