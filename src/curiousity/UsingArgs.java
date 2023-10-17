package curiousity;

public class UsingArgs {
    public static void main(String[] args) {
        for (String s :args) {
            System.out.print("my argument is" + s + " ");
        }

        /**
         *  compile by >    javac UsingArgs.java
         *  run by >        java CommandLineExample the author is emin
         *  output:         Your first argument is: the author is emin
         */

    }

}
