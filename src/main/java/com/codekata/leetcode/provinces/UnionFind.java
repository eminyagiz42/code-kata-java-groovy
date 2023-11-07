package com.codekata.leetcode.provinces;


public class UnionFind {

    private int count;
    private final int[] id;
    private final int[] rank;

    public UnionFind(int n) {
        count = n;
        id = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            id[i] = i;
        }
    }

    public void unionByRank(int u, int v) {
        final int i = find(u);
        final int j = find(v);
        if (i == j) {
            return;
        }
        if (rank[i] < rank[j]) {
            id[i] = j;
        } else if (rank[i] > rank[j]) {
            id[j] = i;
        } else {
            id[i] = j;
            ++rank[j];
        }
        --count;
    }

    public int getCount() {
        return count;
    }

    private int find(int u) {
        return id[u] == u ? u : (id[u] = find(id[u]));
    }
}
