package com.codekata.formatter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ZeroToDouble {

    public static void main(String[] args) {
        String pir = "0";
        System.out.println(new DecimalFormat("###0.00").format(new BigDecimal(pir)));

    }
}
