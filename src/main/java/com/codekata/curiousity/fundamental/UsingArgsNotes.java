package com.codekata.curiousity.fundamental;

/**
 * The type Using args notes.
 */
public class UsingArgsNotes {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        for (String s :args) {
            System.out.print("my argument is" + s + " ");
        }

        /**
         *  compile by >    javac UsingArgs.java
         *  run by >        java CommandLineExample the author is Hello
         *  output:         Your first argument is: the author is Hello
         */
    }
}
