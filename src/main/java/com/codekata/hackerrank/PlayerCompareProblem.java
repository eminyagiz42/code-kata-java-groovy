package com.codekata.hackerrank;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class PlayerCompareProblem {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (Player value : player) {
            System.out.printf("%s %s\n", value.name, value.score);
        }
    }

}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

/**
 * Input:
 * 5
 * amy 100
 * david 100
 * heraldo 50
 * aakansha 75
 * aleksa 150
 */
class Checker implements Comparator<Player> {

    //https://www.hackerrank.com/challenges/java-comparator/problem

    @Override
    public int compare(Player o1, Player o2) {
        final int result = -1 * Integer.compare(o1.score, o2.score);

        if (result == 0) {
            //We consider the alphabetic order if their score are the same
            return StringUtils.compare(o1.name, o2.name);
        }
        return result;
    }
}