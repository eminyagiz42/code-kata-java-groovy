package com.codekata.formatter;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CustomDateFormatter {
    private static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("$#,##0.00");
    private static final NumberFormat CURRENCY_FORMAT2 = NumberFormat.getCurrencyInstance(Locale.US);
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

    public static String getStartDate() {
        String startDate = "2025-02-04 00:00:00.0";
        //String startDate = "";
        //String startDate = null;
        return StringUtils.isBlank(startDate) ? "" : LocalDateTime.parse(startDate, INPUT_FORMAT).format(OUTPUT_FORMAT);
    }

    public static String getYourContributions() {
        //String value = "0.00";
        //String value = "28.000000000000";
        //String value = "00.000000000000";
        //String value = "-387.89065645";
        String value = "3437.32";
        //String value = "";
        //String value = null;
        return StringUtils.isBlank(value) ? "" : CURRENCY_FORMAT2.format(Double.valueOf(value));
    }

        public static BigDecimal formatBigDecimal(Object val, int decimal){
        BigDecimal bigDecimal = null;
        DecimalFormat decimalFormat = null;
        BigDecimal arrObj = null;

        if(val != null) {
            arrObj = (BigDecimal) val;
        }else{
            arrObj = new BigDecimal(0);
        }

        switch (decimal){
            case 1: decimalFormat = new DecimalFormat(CommonConstants.DECIMAL_FORMAT_1); break;
            case 4: decimalFormat = new DecimalFormat(CommonConstants.DECIMAL_FORMAT_4); break;
            default: decimalFormat = new DecimalFormat(CommonConstants.DECIMAL_FORMAT_2); break;
        }
        bigDecimal = new BigDecimal(decimalFormat.format(arrObj));
        return bigDecimal;
    }

    public static void main(String[] args) {
        System.out.println(getStartDate()); // Output: 04 Feb 2025
        System.out.println(getYourContributions());
        System.out.println("done");
    }
}
