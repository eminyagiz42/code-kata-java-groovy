package curiousity.inheritence.interfacenote.impl;

import curiousity.inheritence.interfacenote.ExampleInterface;

public class ExampleInterfaceImpl implements ExampleInterface {

    @Override
    public int addition(int a, int b) {
        return a + b;
    }

    @Override
    public int subtraction(int a, int b) {
        return a - b;
    }
}
