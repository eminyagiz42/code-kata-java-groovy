package com.codekata.leetcode.interview75.second25;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class NearestExit {
    public static void main(String[] args) {
        //https://leetcode.com/problems/nearest-exit-from-entrance-in-maze

        char[][] maze = {{'+','+','.','+'},
                         {'.','.','.','+'},
                         {'+','+','+','.'}};
        int [] entrance = {1,2};
        System.out.println(nearestExit(maze, entrance));
    }


    public static int nearestExit(char[][] maze, int[] entrance) { //Faster Solution
        final int xAxes = maze.length;
        final int yAxes = maze[0].length;
        final int[] directions = {0, 1, 0, -1, 0};
        int result = 0;
        Queue<int[]> queue = new ArrayDeque<>(Arrays.asList(new int[] {entrance[0], entrance[1]}));
        boolean[][] seen = new boolean[xAxes][yAxes];
        seen[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            ++result;
            for (int sz = queue.size(); sz > 0; --sz) {
                final int i = queue.peek()[0];
                final int j = queue.poll()[1];
                for (int k = 0; k < 4; ++k) {
                    final int x = i + directions[k];
                    final int y = j + directions[k + 1];
                    if (x < 0 || x == xAxes || y < 0 || y == yAxes) {
                        continue;
                    }
                    if (seen[x][y] || maze[x][y] == '+') {
                        continue;
                    }
                    if (x == 0 || x == xAxes - 1 || y == 0 || y == yAxes - 1) {
                        return result;
                    }
                    queue.offer(new int[] {x, y});
                    seen[x][y] = true;
                }
            }
        }
        return -1;
    }

    public static int nearestExitOnlyPath(final char[][] maze, int[] entrance) { // a solution with working with only '.' path
        int index = 0;
        int[] path = new int[10];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == '.') {
                    path[index++] = i;
                    path[index++] = j;
                }
            }
        }
        final int length = path.length;
        return 0;
    }

    public static int nearestExit2(final char[][] maze, int[] entrance) { // Unfinished solution
        int x = entrance[0];
        int y = entrance[1];

        int[] possibleMoves = checkPossibleMoves(maze, x, y); //make it recursive
        int x1 = possibleMoves[0];
        int y1 = possibleMoves[1];
        //int[] possibleMoves2 = checkPossibleMoves(maze,x1,y1);
        int x2 = possibleMoves[2];
        int y2 = possibleMoves[3];
        int[] possibleMoves3 = checkPossibleMoves(maze, x2, y2);
        int x3 = possibleMoves3[0];
        int y3 = possibleMoves3[1];
        int[] possibleMoves4 = checkPossibleMoves(maze, x3, y3);

        //check up
        //check right
        //check left
        //check down
        //if it's . get cordination, increase count go to first line

        return 2;
    }

    private static int[] checkPossibleMoves(char[][] maze, int x, int y) {
        int index = 0;
        int[] path = new int[20];
        if (x >= 1 && maze[x -1][y] == '.') {
            System.out.println("up");
            path[index++] = x-1;
            path[index++] = y;
        }
        if (maze[x +1][y] == '.') {
            System.out.println("down");
            path[index++] = x+1;
            path[index++] = y;
        }
        if (maze[x][y +1] == '.') {
            System.out.println("right");
            path[index++] = x;
            path[index++] = y+1;
        }
        if (y >= 2 && maze[x][y -2] == '.') {
            System.out.println("left");
            path[index++] = x;
            path[index++] = y-2;
        }

        /* // Evaluate if it's a exit, right and left wall
        if (maze[path[0]] [path[1]-2] == '+' && maze[path[0]] [path[1]+1] == '+') {
            System.out.println("Yes, left right are wall");
        }

         */
        return path;
    }
}
