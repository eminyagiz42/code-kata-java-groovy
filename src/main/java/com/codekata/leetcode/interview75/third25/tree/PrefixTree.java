package com.codekata.leetcode.interview75.third25.tree;

public class PrefixTree {

    public static void main(String[] args) {

        // https://leetcode.com/problems/implement-trie-prefix-tree/

        Trie trie = new Trie();
        trie.insert("bad");
        trie.insert("dad");
        trie.insert("mad");
        System.out.println(trie.search(".ad"));
    }
}
