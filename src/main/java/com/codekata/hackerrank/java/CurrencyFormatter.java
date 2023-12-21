package com.codekata.hackerrank.java;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * The type Currency formatter.
 */
public class CurrencyFormatter {

    /**
     * The constant INDIA.
     */
    public static final Locale INDIA = new Locale("en", "IN");

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://www.hackerrank.com/challenges/java-currency-formatter/problem

        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        //double payment = 12324.134;

        final String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        final String india  = NumberFormat.getCurrencyInstance(CurrencyFormatter.INDIA).format(payment);
        final String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        final String france  = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
