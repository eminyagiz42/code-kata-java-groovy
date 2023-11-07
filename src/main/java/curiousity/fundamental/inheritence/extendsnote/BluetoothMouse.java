package curiousity.fundamental.inheritence.extendsnote;

public class BluetoothMouse extends MouseBase{

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

    public int getNumber() {
        return number;
    }
}
