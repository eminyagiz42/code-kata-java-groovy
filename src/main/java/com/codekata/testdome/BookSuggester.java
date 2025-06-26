package com.codekata.testdome;

import java.util.*;
import java.util.stream.Collectors;

public class BookSuggester {

    public static void main(String[] args) {
        prepareData();
        System.out.println(suggestPopularBook(100));
    }

    public static Map<Integer, List<Integer>> memberBorrowedBooks = new HashMap<>();
    public static Map<Integer, Integer> bookFrequencyList = new HashMap<>();

    public static void prepareData() {
        // memberId - bookId
        memberBorrowedBooks.put(100, Arrays.asList(1, 2, 3));

        // bookId - numberOfTimesBorrowed
        bookFrequencyList.put(1, 50);
        bookFrequencyList.put(2, 40);
        bookFrequencyList.put(3, 30);
        bookFrequencyList.put(4, 20); // This book have to suggested since 20 > 10
        bookFrequencyList.put(5, 10);
    }

    public static Integer suggestPopularBook(int memberId) {
        if (!memberBorrowedBooks.containsKey(memberId)) {
            System.out.println("Member Id NOT found");
            return null;
        }

        List<Integer> topBooks = bookFrequencyList.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for (int bookId : memberBorrowedBooks.get(memberId)) {
            if (topBooks.contains(bookId)) {
                topBooks.removeIf(b -> b.equals(bookId));
            }
        }
        return topBooks.isEmpty() ? 0 : topBooks.get(0);
    }
}
