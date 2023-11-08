package com.codekata.curiousity.fundamental.inheritence.extendsnote;

/**
 * The type Bluetooth mouse.
 */
public class BluetoothMouse extends MouseBase{

    /**
     * Connect.
     */
    public void connect() {
        System.out.println("Bluetooth is connected!");
    }

    /**
     *  super means it comes from parent class
     *  in inheritance,
     *  Parent Class: MouseBase
     *  Child Class: BluetoothMouse
     */
    private final int number = super.number + 10;

    /**
     * Gets number.
     *
     * @return the number
     */
    public int getNumber() {
        return number;
    }
}
