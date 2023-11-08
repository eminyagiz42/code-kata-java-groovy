package com.codekata.curiousity.tricks;

/**
 * The type Change final notes.
 */
public class ChangeFinalNotes {

    /**
     * The Constant number.
     */
    static final int CONSTANT_NUMBER = 8;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ChangeFinal changeFinal = new ChangeFinal();
        System.out.println(changeFinal.getUpdateMe());

        //CONSTANT_NUMBER = 3; Cannot assign a value to final variable 'CONSTANT_NUMBER'
    }
}
