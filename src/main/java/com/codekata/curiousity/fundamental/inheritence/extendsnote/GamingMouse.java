package com.codekata.curiousity.fundamental.inheritence.extendsnote;

public class GamingMouse extends MouseBase {

    private final int[] macros = {1,2,3};
    private int index = 0;

    public void switchMacros() {
        final int selected = macros[index++ % 3];
        System.out.println("Macro " + selected + " is selected!");
    }

    /**
     *  super means it comes from parent class
     *  in inheritance,
     *  Parent Class: MouseBase
     *  Child Class: GamingMouse
     */
    public void extendedRightClick(String mouseName) {
        super.rightClick(mouseName);
        System.out.println("and this is extended method");
    }

    // Polymorphism means override a method and update it.
    @Override // This is best practices since we have same method in the parent
    public void rightClick(String mouseName) {
        super.rightClick(mouseName); // if i need the parent method, call by super
        System.out.println("and hello from child method");
    }
}
