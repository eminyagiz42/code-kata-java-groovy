package com.codekata.curiousity.fundamental.inheritence.extendsnote;

/**
 * The type Mouse base.
 */
public class MouseBase {

    /**
     * The Number.
     */
    int number = 10;

    /**
     * Right click.
     *
     * @param mouseName the mouse name
     */
    public void rightClick(String mouseName) {
        System.out.println( mouseName + " is right clicked!");
    }

    /**
     * Left click.
     *
     * @param mouseName the mouse name
     */
    public void leftClick(String mouseName) {
        System.out.println( mouseName + " is left clicked!");
    }
}
