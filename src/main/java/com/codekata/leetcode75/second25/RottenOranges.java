package com.codekata.leetcode75.second25;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {

        //https://leetcode.com/problems/rotting-oranges/

        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        if(count_fresh == 0) {
            return 0;
        }
        int count = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int[] direct : directions) {
                    int x = point[0] + direct[0];
                    int y = point[1] + direct[1];
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2){
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[]{x , y});
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? count-1 : -1;
    }
}
