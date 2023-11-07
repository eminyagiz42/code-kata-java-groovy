package curiousity.fundamental.inheritence.interfacenote.impl;

import curiousity.fundamental.inheritence.interfacenote.ExampleInterface;

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
