package com.codekata.assesment;

import java.util.ArrayList;
import java.util.List;

public class PassingByRefOrValue {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("foo");

        List<String> list2 = list1;
        List<String> list3 = new ArrayList<>(list2);

        list1.clear();
        list2.add("bar");
        list3.add("baz");

        System.out.println(list1); // [bar]
        System.out.println(list2); // [bar]
        System.out.println(list3); // [foo, baz]

    }
}
