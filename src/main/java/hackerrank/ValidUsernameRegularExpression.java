package hackerrank;

import java.util.Scanner;

public class ValidUsernameRegularExpression {

    //Problem: https://www.hackerrank.com/challenges/valid-username-checker/problem

    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();
            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
    }
}
