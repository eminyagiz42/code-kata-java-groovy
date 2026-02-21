package com.codekata.formatter;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

public class JustIRDNumberFormat {

    public static void main(String[] args) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        String irdNumber = "123456789";
        char[] charArray = irdNumber.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            builder.append(charArray[i]);
            if (i == 2 || i == 5) {
                builder.append('-');
            }
        }
        System.out.println(builder.toString());// output: 123-456-789
        stopWatch.stop();
        System.out.println("Time: " + stopWatch.getTime(TimeUnit.NANOSECONDS) + " ns");


        stopWatch.reset();
        stopWatch.start();
        String formatted = irdNumber.substring(0, 3) + '-' +
                irdNumber.substring(3, 6) + '-' +
                irdNumber.substring(6);
        System.out.println(formatted);
        stopWatch.stop();
        System.out.println("Time: " + stopWatch.getTime(TimeUnit.NANOSECONDS) + " ns");

        stopWatch.reset();
        stopWatch.start();
        StringBuilder builder2 = new StringBuilder(11); // Pre-size: 9 digits + 2 hyphens
        builder2.append(irdNumber, 0, 3)
                .append('-')
                .append(irdNumber, 3, 6)
                .append('-')
                .append(irdNumber, 6, 9);
        System.out.println(builder2);
        stopWatch.stop();
        System.out.println("Time: " + stopWatch.getTime(TimeUnit.NANOSECONDS) + " ns");


/*
Results:
        123-456-789
        Time: 152625 ns
        123-456-789
        Time: 4303917 ns
        123-456-789
        Time: 25709 ns

 */

    }
}
