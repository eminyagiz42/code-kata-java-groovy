package curiousity.inheritence;

import curiousity.inheritence.abstractnote.MathCalculator;
import curiousity.inheritence.interfacenote.ExampleInterface;
import curiousity.inheritence.interfacenote.impl.ExampleInterfaceImpl;

public class InheritanceNotes {

    public static void main(String[] args) {

        // Interface
        ExampleInterface exampleInterface = new ExampleInterfaceImpl();
        int a = 13, b = 4;
        final int addition = exampleInterface.addition(a, b);
        System.out.println(a + " addition " + b + " = " + addition);

        final int subtraction = exampleInterface.subtraction(a, b);
        System.out.println(a + " subtraction " + b + " = " + subtraction);

        //Abstract Class
        MathCalculator mathCalculator = new MathCalculator();
        int x = 5, y = 2; // calculateExponential comes from ExampleAbstract class
        final int exponential = mathCalculator.calculateExponential(x, y);
        System.out.println(x + " exponential " + y + " = " + exponential);
    }
}
