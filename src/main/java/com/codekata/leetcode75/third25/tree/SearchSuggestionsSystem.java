package com.codekata.leetcode75.third25.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchSuggestionsSystem {

    public static void main(String[] args) {

        // https://leetcode.com/problems/search-suggestions-system/

        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";

        //By Trie Objects
        System.out.println(suggestedProducts(products, searchWord));

        //Alternative ways
        List<String> list = Arrays.asList(products);
        List<List<String>> result = solveWithoutTrieNode(list, searchWord);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> results = new ArrayList<>();
        for (final String product : products) {
            Trie.insertWord(product);
        }
        TrieNode node = Trie.getRoot();
        for (final char c : searchWord.toCharArray()) {
            if (node == null || node.children[c - 'a'] == null) {
                node = null;
                results.add(new ArrayList<>());
                continue;
            }
            node = node.children[c - 'a'];
            results.add(Trie.searchWord(node));
        }
        return results;
    }

    public static List<List<String>> solveWithoutTrieNode(List<String> products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); ++i) {
            final int index = i;
            String entered = searchWord.substring(0, index);
            List<String> beginWith = products.stream()
                    .filter(word -> word.length() >= index &&
                            word.substring(0, index).equals(entered))
                    .collect(Collectors.toList());

            int limit = 3;
            beginWith = beginWith.stream()
                    .sorted(String::compareTo)
                    .limit(limit)
                    .collect(Collectors.toList());
            result.add(beginWith);
        }
        return result;
    }

}
