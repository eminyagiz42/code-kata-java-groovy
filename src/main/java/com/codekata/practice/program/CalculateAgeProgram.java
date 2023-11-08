package com.codekata.practice.program;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 * The type Calculate age program.
 */
public class CalculateAgeProgram {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, What is your name ?");
        final String name = scanner.next();

        System.out.println("Let's calculate your age");
        System.out.println("Tell me your birth day (Day:Number)");
        final int day = Integer.parseInt(scanner.next());
        System.out.println("Tell me your birth month (Month:Number)");
        final int month = Integer.parseInt(scanner.next());
        System.out.println("Tell me your birth year (Year:Number)");
        final int year = Integer.parseInt(scanner.next());

        final Period age = Period.between(LocalDate.of(year, month, day), LocalDate.now());
        System.out.println("Hey " + name + ", Your age is " + age.getYears());

        final Period remaining = Period.between(LocalDate.now(), LocalDate.of(LocalDate.now().getYear() + 1, month, day));
        if (remaining.getMonths() != 0) {
            System.out.print(Math.abs(remaining.getMonths()) +" month and " );
        }
        System.out.println(Math.abs(remaining.getDays()) + " days remained to your next birthday.");
    }
}
