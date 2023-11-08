package com.codekata.curiousity.fundamental.inheritence;

import com.codekata.curiousity.fundamental.inheritence.extendsnote.BluetoothMouse;
import com.codekata.curiousity.fundamental.inheritence.extendsnote.GamingMouse;
import com.codekata.curiousity.fundamental.inheritence.extendsnote.MouseBase;
import com.codekata.curiousity.fundamental.inheritence.interfacenote.impl.ExampleInterfaceImpl;
import com.codekata.curiousity.fundamental.inheritence.superconstructor.CartStatusEnum;
import com.codekata.curiousity.fundamental.inheritence.superconstructor.CartTypeEnum;
import com.codekata.curiousity.fundamental.inheritence.superconstructor.CartV2;
import com.codekata.curiousity.fundamental.inheritence.abstractnote.ExampleAbstract;
import com.codekata.curiousity.fundamental.inheritence.abstractnote.MathCalculator;
import com.codekata.curiousity.fundamental.inheritence.interfacenote.ExampleInterface;

import java.math.BigDecimal;

/**
 * The type Inheritance notes.
 */
public class InheritanceNotes {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        // Extends Class
        BluetoothMouse bluetoothMouse = new BluetoothMouse();
        bluetoothMouse.leftClick("bluetoothMouse");
        bluetoothMouse.rightClick("bluetoothMouse");
        bluetoothMouse.connect();
        System.out.println(bluetoothMouse.getNumber());
        System.out.println();
        GamingMouse gamingMouse = new GamingMouse();
        gamingMouse.leftClick("gamingMouse");
        gamingMouse.rightClick("gamingMouse");
        gamingMouse.switchMacros();
        gamingMouse.switchMacros();
        gamingMouse.switchMacros();
        gamingMouse.switchMacros();
        gamingMouse.extendedRightClick("gaming mouse");
        System.out.println();


        //Super constructor
        CartV2 cartV2 = new CartV2("customerId", BigDecimal.TEN, CartTypeEnum.ROOT_CART, CartStatusEnum.SHOPPING, 1);
        System.out.println(cartV2.toString()); // CartV2{Cart{customerId='customerId', grandTotal=10, type=ROOT_CART, status=SHOPPING}, extendedCartId=1}
        //In objects we can use it, it helps readability for logging a lot.

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


        /**
         * instanceof keyword checks
         * weather it is belonging to the class, subclass or interface
         */
        if (gamingMouse instanceof MouseBase) { // true
            System.out.println("yes gamingMouse is instance of MouseBase");
        }
        if (exampleInterface instanceof ExampleInterfaceImpl) { // true
            System.out.println("yes exampleInterface is instance of ExampleInterfaceImpl");
        }
        if (mathCalculator instanceof ExampleAbstract) { // true
            System.out.println("yes mathCalculator is instance of ExampleAbstract");
        }

        MathCalculator mathCalculator2 = null;
        System.out.println(mathCalculator2 instanceof ExampleAbstract); // false
        // because constructor not created the object yet
    }
}
