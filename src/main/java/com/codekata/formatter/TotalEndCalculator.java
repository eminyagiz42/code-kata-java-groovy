package com.codekata.formatter;

import java.math.BigDecimal;

public class TotalEndCalculator {

    public static void main(String[] args) {
        FinanceModel model = new FinanceModel();

        model.setOne(new BigDecimal("30000003.009"));
        model.setTwo(new BigDecimal("-70000003.009"));

        System.out.println(model.getTotal());
    }
}
