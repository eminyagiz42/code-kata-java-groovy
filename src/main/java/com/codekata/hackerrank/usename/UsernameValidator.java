package com.codekata.hackerrank.usename;


/**
 * The type Username validator.
 */
class UsernameValidator {
    /**
     * The constant REGULAR_EXPRESSION.
     */
    public static final String REGULAR_EXPRESSION = "^[[A-Z][a-z]][[A-Za-z0-9_]]{7,29}$";
}

/*

^                       # Start of the line
   [A-Z][a-z]]          # First character will be A-z  --> uppercase  a-z --> lowercase
   [[A-Za-z0-9_]]       # Rest of the word can contains A-z, a-z, 0-9, underscore
    {7,29}              # Length at least 8 characters and maximum length of 30 (we add first character to total)
$                       # End of the line

*/
