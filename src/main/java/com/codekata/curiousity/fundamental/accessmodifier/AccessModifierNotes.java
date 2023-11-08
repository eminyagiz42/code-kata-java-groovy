package com.codekata.curiousity.fundamental.accessmodifier;

import com.codekata.curiousity.fundamental.accessmodifier.package1.ClassB;

/**
 * The type Access modifier notes.
 */
public class AccessModifierNotes {

    /**
     * Modifier   | Class | Package | Subclass | Global |
     * -----------|-------|---------|----------|--------|
     * public     |  Yes  |  Yes    |  Yes     |  Yes   |
     * protected  |  Yes  |  Yes    |  Yes     |  No    |
     * default    |  Yes  |  Yes    |  No      |  No    |
     * private    |  Yes  |  No     |  No      |  No    |
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ClassB classB = new ClassB();

        classB.learnAccessModifiers();
    }
}
