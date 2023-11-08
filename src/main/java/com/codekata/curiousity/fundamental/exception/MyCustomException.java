package com.codekata.curiousity.fundamental.exception;

/**
 * The type My custom exception.
 */
public class MyCustomException extends Exception {

    /**
     * Instantiates a new My custom exception.
     */
    public MyCustomException() {
    }

    /**
     * Instantiates a new My custom exception.
     *
     * @param str the str
     */
    MyCustomException(String str) {
        super(str);
    }
}
