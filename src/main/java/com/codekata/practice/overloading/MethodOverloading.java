package com.codekata.practice.overloading;

import java.lang.reflect.Method;


/**
 * The type Method overloading.
 */
public class MethodOverloading {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main( String args[] ) {
        PrinterModel myPrinter = new PrinterModel();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : PrinterModel.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");
      
    }
}