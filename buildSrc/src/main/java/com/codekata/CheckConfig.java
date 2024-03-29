package com.codekata;

import com.codekata.utility.ConfigurationReader;

public class CheckConfig {

    public static void main(String[] args) {
        final String property = ConfigurationReader.getProperty("this.is.property");

        System.out.println(property);
    }
}
