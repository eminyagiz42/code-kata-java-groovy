package com.codekata.leetcode75.third25.tree;


import java.util.ArrayList;
import java.util.List;

public class Trie {

    private static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static TrieNode getRoot() {
        return root;
    }


    public static void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] word, int start, TrieNode root) {
        if (root == null) return false;
        if (start == word.length) return root.isWord;
        if (word[start] == '.') {
            for (TrieNode node : root.children) {
                if (search(word, start + 1, node)) {
                    return true;
                }
            }
            return false;
        }
        if (root.children[word[start] - 'a'] == null) return false;
        return search(word, start + 1, root.children[word[start] - 'a']);
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return true;
    }

    static void insertWord(final String word) {
        TrieNode node = root;
        for (final char c : word.toCharArray()) {
            final int i = c - 'a';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.word = word;
    }

    static List<String> searchWord(TrieNode node) {
        List<String> res = new ArrayList<>();
        dfs(node, res);
        return res;
    }

    private static void dfs(TrieNode node, List<String> ans) {
        if (ans.size() == 3)
            return;
        if (node == null)
            return;
        if (node.word != null)
            ans.add(node.word);
        for (TrieNode child : node.children)
            dfs(child, ans);
    }

}

