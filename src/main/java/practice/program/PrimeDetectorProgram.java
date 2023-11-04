package practice.program;

import java.util.Scanner;

public class PrimeDetectorProgram {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me a number that you want to know weather it is prime number or not");

        while (scanner.hasNextInt()) {
            if (isPrime(scanner.nextInt())) {
                System.out.println("Yes, it is a Prime number");
            } else {
                System.out.println("No, it is  not");
            }
        }
        scanner.close();
    }

    public static boolean isPrime(int number) {
        for (int i = number / 2; i > 1; i--) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
