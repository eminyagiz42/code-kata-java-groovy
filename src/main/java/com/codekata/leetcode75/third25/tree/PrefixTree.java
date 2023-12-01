package com.codekata.leetcode75.third25.tree;

public class PrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("bad");
        trie.insert("dad");
        trie.insert("mad");
        System.out.println(trie.search(".ad"));
    }
}
