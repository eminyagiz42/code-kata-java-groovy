package com.codekata.hackerrank.certificate.java;


import java.util.Scanner;

class JavaSkillsCertificate {

    public static void main(String[] args) {
        Parser parser = new Parser();

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }

        in.close();
    }
}

class Parser {

    public static final String REGEX_PATTERN = "\\(\\)|\\[\\]|\\{\\}";

    static String isBalanced(String s) {
        while (s.length() != (s = s.replaceAll(REGEX_PATTERN, "")).length());

        return String.valueOf(s.isEmpty()); // Output: String "true" "false"
    }
}
