package com.codekata.leetcode.provinces;


/**
 * The type Union find.
 */
public class UnionFind {

    private int count;
    private final int[] id;
    private final int[] rank;

    /**
     * Instantiates a new Union find.
     *
     * @param n the n
     */
    public UnionFind(int n) {
        count = n;
        id = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            id[i] = i;
        }
    }

    /**
     * Union by rank.
     *
     * @param u the u
     * @param v the v
     */
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

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }

    private int find(int u) {
        return id[u] == u ? u : (id[u] = find(id[u]));
    }
}
