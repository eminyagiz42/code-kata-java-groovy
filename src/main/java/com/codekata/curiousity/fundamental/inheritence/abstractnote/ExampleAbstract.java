package com.codekata.curiousity.fundamental.inheritence.abstractnote;

/**
 * The type Example abstract.
 */
public abstract class ExampleAbstract {

    /**
     * Interface vs Abstract Class
     * Interface supports only outline to override the methods
     * it doesn't let you to do an implementation
     * If I expected some implementation accessible
     * in all extended classes I must use abstract class
     * because it supports the implementations
     *
     * @param number the number
     * @param exp    the exp
     * @return the int
     */
    public int calculateExponential(int number,int exp) {
            return (int) Math.pow(number, exp);
    }
}