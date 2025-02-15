package com.codekata.codereview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class SimpleDateFormatMethodChecker {

    public static void main(String[] args) throws ParseException {

        DefaultEcommerceDateUtils utils = new DefaultEcommerceDateUtils();

        Optional<String> date = utils.convertWithPatternAndFormat("2024-11-20 13:00:00", "yyyy-MM-dd HH:mm:ss", "MMM d, yyyy, h:mm:ss a");

        if (date.isPresent()) {
            System.out.println(date.get());
            SimpleDateFormat outputFormat = new SimpleDateFormat("MMM d, yyyy, h:mm:ss a");
            System.out.println(outputFormat.parse(date.get()));
            Optional<Date> dateOptional = utils.convert(date.get(), "MMM d, yyyy, h:mm:ss a");
            if (dateOptional.isPresent()) {
                System.out.println(dateOptional.get());
            }
            System.out.println( new Date(date.get()));
        } else {
            System.out.println("EMPTY");
        }
    }
}
