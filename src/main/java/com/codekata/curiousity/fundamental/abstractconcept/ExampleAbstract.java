package com.codekata.curiousity.fundamental.abstractconcept;

public abstract class ExampleAbstract implements ExampleInterface {

    public ExampleAbstract() {
        System.out.println("Hello from ExampleAbstract constructor");
    }

    abstract void init();

    @Override
    public void interfaceMethod() {

    }

    @Override
    public void interfaceMethod1() {

    }

}
