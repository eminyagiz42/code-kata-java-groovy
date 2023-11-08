package com.codekata.curiousity.librarykata.lombok;

import lombok.Builder;
import lombok.Getter;

/**
 * The type Student model.
 */
@Builder
@Getter
public class StudentModel {

    private final int id;
    private final String name;
}
