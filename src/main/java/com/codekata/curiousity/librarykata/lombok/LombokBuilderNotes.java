package com.codekata.curiousity.librarykata.lombok;

public class LombokBuilderNotes {

    public static void main(String[] args) {

        final StudentModel studentModel = StudentModel.builder()
                .id(1)
                .name("emin")
                .build();

        System.out.println(studentModel.getId() + " " + studentModel.getName());

    }
}
