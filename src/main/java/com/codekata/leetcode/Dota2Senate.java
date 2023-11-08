package com.codekata.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type Dota 2 senate.
 */
public class Dota2Senate {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //https://leetcode.com/problems/dota2-senate/
        String senate = "RDD"; // Dire
        String senate1 = "RD"; // Radiant
        System.out.println(predictPartyVictory(senate));
    }

    /**
     * Predict party victory string.
     *
     * @param senate the senate
     * @return the string
     */
    public static String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<Character>();
        int radiantCount = 0, direCount = 0;
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            char party = senate.charAt(i);
            queue.offer(party);
            if (party == 'R')
                radiantCount++;
            else
                direCount++;
        }
        int radiantBanCount = 0, direBanCount = 0;
        while (radiantCount > 0 && direCount > 0) {
            char party = queue.poll();
            if (party == 'R') {
                if (radiantBanCount > 0)
                    radiantBanCount--;
                else {
                    direCount--;
                    direBanCount++;
                    queue.offer(party);
                }
            } else {
                if (direBanCount > 0)
                    direBanCount--;
                else {
                    radiantCount--;
                    radiantBanCount++;
                    queue.offer(party);
                }
            }
        }
        return radiantCount > 0 ? "Radiant" : "Dire";
    }
}
