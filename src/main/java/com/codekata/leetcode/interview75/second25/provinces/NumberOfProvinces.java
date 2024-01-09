package com.codekata.leetcode.interview75.second25.provinces;

/**
 * The type Number of provinces.
 */
class NumberOfProvinces {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        // https://leetcode.com/problems/number-of-provinces

        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        System.out.println(findCircleNum(isConnected));
    }

    /**
     * Find circle num int.
     *
     * @param isConnected the is connected
     * @return the int
     */
    public static int findCircleNum(int[][] isConnected) {
        final int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (isConnected[i][j] == 1) {
                    unionFind.unionByRank(i, j);
                }
            }
        }
        return unionFind.getCount();
    }
}

