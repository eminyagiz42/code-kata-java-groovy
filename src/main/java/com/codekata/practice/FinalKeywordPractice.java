package com.codekata.practice;

/**
 * The type Final keyword practice.
 */
public class FinalKeywordPractice {

    /**
     * The X.
     */
    String x = "3";
    /**
     * The Y.
     */
    String y = "4";

    /**
     * Instantiates a new Final keyword practice.
     *
     * @param x the x
     * @param y the y
     */
    public FinalKeywordPractice(String x, String y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        final String a = "test";
        FinalKeywordPractice practice2 = new FinalKeywordPractice("5", "6");
        System.out.print(practice2.useThis());
    }

    /**
     * Use this string.
     *
     * @return the string
     */
    public String useThis() {
        return this.printThem();
    }

    /**
     * Print them string.
     *
     * @return the string
     */
    public String printThem() {
        FinalKeywordPractice practice = new FinalKeywordPractice("7", "8");
        if (this == practice) {
            return "same Model ?";
            //} else if ( this.x == practice.x) {
            //	return "same variable";
        } else if (this.toString() == practice.toString()) {
            return "same when string";
        }
        //return this.toString() + " and " + practice.toString() ;
        //return this.x + " and " + this.y ; // 7 and 8
        return practice.x + " and " + practice.y; // 5 and 6
    }
}
