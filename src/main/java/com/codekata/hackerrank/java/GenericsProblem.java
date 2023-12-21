package com.codekata.hackerrank.java;


public class GenericsProblem {

    public static void main(String[] args) {

        //https://www.hackerrank.com/challenges/java-generics/problem
        
        //Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        // myPrinter.printArray(intArray);
        // myPrinter.printArray(stringArray);
        printArray(intArray);
        printArray(stringArray);
        /*
        int count = 0;
        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();
            if(name.equals("printArray")) {
                count++;
            }
        }
        if(count > 1) {
            System.out.println("Method overloading is not allowed!");
        }
         */
    }

    private static <T> void printArray(T[] arr) {
        for (T value : arr) {
            System.out.println(value);
        }
    }

    /* Overloading
    private static void printArray(String[] stringArr) {
        for (String value : stringArr) {
            System.out.println(value);
        }
    }

    private static void printArray(int[] integerArr) {
        for (int num : integerArr) {
            System.out.println(num);
        }
    }
     */
}

// Alternative Solution
class Printer {
    <T> void printArray(T[] elements) {
        for (T element : elements) {
            System.out.println(element);
        }
    }
}
