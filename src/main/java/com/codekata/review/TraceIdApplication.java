package com.codekata.review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class TraceIdApplication {

    private static final Logger logger = LoggerFactory.getLogger(TraceIdApplication.class);

    public static void main(String[] args) {

        logger.info("hello1");

        System.out.println(MDC.getCopyOfContextMap());
        //System.out.println(MDC.getCopyOfContextMap().get("traceId"));
        System.out.println("Hello");
    }
}
