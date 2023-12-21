package com.codekata.hackerrank.java.usename;

import java.util.Scanner;

/**
 * The type Valid username regular expression.
 */
public class ValidUsernameRegularExpression {

    //Problem: https://www.hackerrank.com/challenges/valid-username-checker/problem

    private static final Scanner scan = new Scanner(System.in);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();
            if (userName.matches(UsernameValidator.REGULAR_EXPRESSION)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
    }
}
