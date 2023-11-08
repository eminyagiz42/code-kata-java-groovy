package com.codekata.curiousity.librarykata.lombok;

/**
 * The type Lombok builder notes.
 */
public class LombokBuilderNotes {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        final StudentModel studentModel = StudentModel.builder()
                .id(1)
                .name("emin")
                .build();

        System.out.println(studentModel.getId() + " " + studentModel.getName());

    }
}
