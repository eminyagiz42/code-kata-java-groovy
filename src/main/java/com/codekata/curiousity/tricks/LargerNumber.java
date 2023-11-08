package com.codekata.curiousity.tricks;

/**
 * The type Larger number.
 */
public class LargerNumber {

    /**
     * The constant EXAMPLE_CONSTANT_VARIABLE.
     */
    public static final int EXAMPLE_CONSTANT_VARIABLE = 2;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        int a = 5, b = 7, largerNum;
        if (a > b) {
            largerNum = a;
        }else {
            largerNum = b;
        }

        //better solution - short if
        largerNum = a > b ? a : b;

        //Even better solution - using existing library
        largerNum = Math.max(a,b);

    }

    /**
     * Is greater boolean.
     *
     * @param num1 the num 1
     * @param num2 the num 2
     * @return the boolean
     */
    public boolean isGreater(int num1, int num2){
        return num1 > num2;
    }
}
