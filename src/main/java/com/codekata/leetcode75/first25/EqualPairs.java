package com.codekata.leetcode75.first25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Equal pairs.
 */
public class EqualPairs {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        // https://leetcode.com/problems/equal-row-and-column-pairs

        // int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        // int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        int[][] grid = {{3,1,2,2},{1,4,4,4},{2,4,2,2},{2,5,2,2}};
        System.out.println(equalPairs(grid));
    }

    /**
     * Equal pairs int.
     *
     * @param grid the grid
     * @return the int
     */
    public static int equalPairs(int[][] grid) {
        int counter = 0;
        final int[][] transposed = transpose(grid);
        for (int[] rowGrid : grid) {
            for (int[] rowTranspose : transposed) {
                if (isIntArraySame(rowTranspose,rowGrid)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static boolean isIntArraySame(int[] rowTranspose, int[] rowGrid) {
        for (int i = 0; i < rowGrid.length; i++) {
            if (rowTranspose[i] != rowGrid[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Transpose int [ ] [ ].
     *
     * @param matrix the matrix
     * @return the int [ ] [ ]
     */
    public static int[][] transpose(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] transposedMatrix = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    /**
     * In this approach, it solves that how many duplicated numbers exist in row,
     * and returns the majority of duplicated number
     *
     * @param grid the grid
     * @return the int
     */
    public static int equalPairsOutOfScope(int[][] grid) {
        for (int[] ints : grid) {
            duplicates(ints);
        }
        return findMajority(countArr);
    }

    private static final List<Integer> countArr = new ArrayList<>();

    /**
     * Duplicates.
     *
     * @param codeList the code list
     */
    public static void duplicates(final int[] codeList) {
        Set<Integer> lump = new HashSet<Integer>();
        for (int i : codeList) {
            if (lump.contains(i)) {
                countArr.add(i);
                break;
            }
            lump.add(i);
        }
    }

    /**
     * Find majority int.
     *
     * @param arr the arr
     * @return the int
     */
    public static int findMajority(List<Integer> arr) {
        int maxCount = 0;
        for (int i = 0; i < arr.size(); i++) {
            int count = 0;
            for (int k : arr) {
                if (arr.get(i) == k)
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
       return maxCount;
    }
}
