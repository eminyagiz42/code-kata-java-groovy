package com.codekata.practice.game.snake;

import java.util.Arrays;
import java.util.Scanner;

public class SnakeGame {

    //TODO Not finished

    public static String[][] gameArea = {
            {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
            {"*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*"},
            {"*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*"},
            {"*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*"},
            {"*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*"},
            {"*", " ", " ", " ", " ", " ", " ", " ", " ", "0", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*"},
            {"*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*"},
            {"*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*"},
            {"*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*"},
            {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*"}};

    public static void main(String[] args) {

        printGameArea(gameArea);

        System.out.println(gameArea.length);// 10
        System.out.println(gameArea[0].length); // 20

        //snakeInitialLocation gameArea[5][9]
        
        int x = 5;
        int y = 9;

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                final String key = scanner.next();
                if ("w".equals(key)) {
                    gameArea[x][y] = "";
                    x = (x - 1 + 10) % 10;
                    gameArea[x][y] = "0";
                }
                if ("s".equals(key)) {
                    gameArea[x][y] = "";
                    x = (x + 1) % 10;
                    gameArea[x][y] = "0";
                }
                if ("a".equals(key)) {
                    gameArea[x][y] = "";
                    y = (y - 1 + 20) % 20;
                    gameArea[x][y] = "0";
                }
                if ("d".equals(key)) {
                    gameArea[x][y] = "";
                    y = (y + 1) % 20;
                    gameArea[x][y] = "0";
                }
                printGameArea(gameArea);
            }
        }
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void printGameArea(String[][] gameArea) {
        for (String[] strings : gameArea) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println("");
        }
    }

}

