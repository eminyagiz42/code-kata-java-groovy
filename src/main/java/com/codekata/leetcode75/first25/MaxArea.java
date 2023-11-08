package com.codekata.leetcode75.first25;

/**
 * The type Max area.
 */
public class MaxArea {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/container-with-most-water

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        // (index of 7 - index of 8 ) * 7 which is smaller one -->  ( 8 -1 ) * 7 = 49
        //  int[] height = {1,2,1};
        System.out.print(maxArea(height));
    }

    /**
     * Solution 3 : This solution is the quickest because it is O(n) complexity
     *
     * @param height the height
     * @return the int
     */
    public static int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int totalArea = 0;
        for (int i = 0; i < height.length; i++) {
            if (leftIndex == rightIndex) {
                return totalArea;
            }
            final int leftHeight = height[leftIndex];
            final int rightHeight = height[rightIndex];
            int area = (rightIndex - leftIndex) * Math.min(leftHeight, rightHeight);
            if (area > totalArea) {
                totalArea = area;
            }
            if (leftHeight < rightHeight) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return totalArea;
    }

    /**
     * Solution 2 : This solution is recursive
     *
     * @param height the height
     * @return the int
     */
    public static int maxAreaRecursive(int[] height) {
        int maxFirst = 0;
        int firstIndex = 0;
        int totalArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxFirst = height[i];
            firstIndex = i;
            totalArea = getRecursivelyTotalArea(firstIndex, ++firstIndex, maxFirst, totalArea, height);
        }
        return totalArea;
    }

    private static int getRecursivelyTotalArea(int firstIndex, int secondIndex, int maxFirst, int totalArea, int[] height) {
        if (secondIndex < height.length) {
            int area = (secondIndex - firstIndex) * Math.min(maxFirst, height[secondIndex]);
            if (area > totalArea) {
                totalArea = area;
            }
            return getRecursivelyTotalArea(firstIndex, ++secondIndex, maxFirst, totalArea, height);
        } else {
            return totalArea;
        }
    }

    /**
     * Solution 1 : This solution is slower because it is O(n^2) complexity
     *
     * @param height the height
     * @return the int
     */
    public static int maxAreaSlow(int[] height) {
        int maxFirst = 0;
        int firstIndex = 0;
        int totalArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxFirst = height[i];
            firstIndex = i;
            for (int secondIndex = i + 1; secondIndex < height.length; secondIndex++) {
                final int smaller = Math.min(maxFirst, height[secondIndex]);
                int area = (secondIndex - firstIndex) * smaller;
                if (area > totalArea) {
                    totalArea = area;
                }
            }
        }
        return totalArea;
    }
}

