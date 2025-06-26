package com.codekata.study;

import java.util.List;

public class ExceptionTest {

    public static void main(String[] args) {
        ExceptionTest test = new ExceptionTest();
        try {
            System.out.println(test.divide(10 , 0));
        } catch (Exception e) {
            System.out.println("dvide 10!");
        }
    }

    public Integer divide(int a, int b) {
        try {
            return a/b;
        }finally {
            System.out.println("finally");
        }
    }

    void addMethodObjectList(List<Object> list) {
        list.add("foo");
    }

    void addMethodObjetList(List<String> list) {
        list.add("foo");
    }

    void addMethodOb3tList(List<? super String> list) {
        list.add("foo");
    }

    void addMethodjectList(List list) {
        list.add("foo");
    }

    void addMethodO43tList(List<? extends String> list) {
       // list.add("foo");
    }

    <T> void addMethod4O43tList(List<T> list) {
        //    list.add("foo");
    }
}
