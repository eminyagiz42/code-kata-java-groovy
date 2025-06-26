package com.codekata.assesment;

import java.util.*;

public class CollectionQuestion {

    public static void main(String[] args) {

        Collection<String> collection;

        //collection = new TreeSet<>(); // NOT same order
        //collection = new ArrayList<>();
        //collection = new LinkedList<>();
        //collection = new PriorityQueue<>();// NOT Same order added to collection
        //collection = new ArrayDeque<>();
        collection = new LinkedHashSet<>();

        collection.add("foo");
        collection.add("bar");
        collection.add("baz");

        collection.forEach(System.out::println);
    }
}
