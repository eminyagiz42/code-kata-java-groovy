package com.codekata.curiousity.librarykata.common.lang;


import org.apache.commons.lang3.StringUtils;

/**
 * The type Commons lang practice.
 */
public class CommonsLangPractice {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        StringUtils.isMixedCase("abC");
        StringUtils.isNotEmpty("test");
        String str = StringUtils.EMPTY;
    }
}
