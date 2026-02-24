package com.codekata.formatter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class FinanceModel {
    private static final NumberFormat CURRENCY_FORMAT2 = NumberFormat.getCurrencyInstance(Locale.US);

    BigDecimal one;
    BigDecimal two;
    String total;


    public String getOne() {
        return CURRENCY_FORMAT2.format(one);
    }

    public void setOne(BigDecimal one) {
        this.one = one;
    }

    public String getTwo() {
        return CURRENCY_FORMAT2.format(one);
    }

    public void setTwo(BigDecimal two) {
        this.two = two;
    }

    public String getTotal() {
        List<BigDecimal> amounts = new ArrayList<>();
        amounts.add(one);

        if (two != null) {
            amounts.add(two);
        }
        BigDecimal total = amounts.stream()
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return NumberFormat.getCurrencyInstance(Locale.US).format(total);
    }

}