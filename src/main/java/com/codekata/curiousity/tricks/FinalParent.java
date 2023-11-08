package com.codekata.curiousity.tricks;

/**
 * The type Final parent.
 */
public class FinalParent { // if a class is final, another class cannot extend it.

    /**
     * Print hello.
     */
    final public void printHello(){ //it's final so, child class cannot override it.
        System.out.println("Hello");
    }
}
