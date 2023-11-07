package com.codekata.curiousity.fundamental.inheritence.extendsnote;

public class MouseBase {

    int number = 10;

    public void rightClick(String mouseName) {
        System.out.println( mouseName + " is right clicked!");
    }

    public void leftClick(String mouseName) {
        System.out.println( mouseName + " is left clicked!");
    }
}
