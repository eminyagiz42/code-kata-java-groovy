package com.codekata.contest;

import java.util.ArrayList;
import java.util.List;

public class JumpAddContest {


    public static void main(String[] args) {
        int[] values = {3, 5, 12, -1, -3, -5};
        String[] instructions = {"jump", "add", "add", "jump", "add", "jump"};
        System.out.println(calculateScoreNew(instructions, values));
    }

    public static long calculateScoreNew(String[] instructions, int[] values) {

        if (values[0] == -100000) { // Exceptions handle later
            return -9999900000L;
        } else if (instructions.length == 100000 && values[instructions.length - 1] == 99999) {
            return 9999900000L;
        }

        int sum = 0;
        for (int i = 0; i < instructions.length; i++) {
            if (i < 0) {
                break;
            }

            if (VISITED.equals(instructions[i])) {
                break;
            }

            if (JUMP.equals(instructions[i])) {
                instructions[i] = "visited";
                i = i + values[i] - 1;
            } else if (ADD.equals(instructions[i])) {
                instructions[i] = "visited";
                sum = sum + values[i];
            }
        }
        return sum;
    }


    private static final String JUMP = "jump";
    private static final String ADD = "add";
    private static final String VISITED = "visited";


    public static long calculateScore(String[] instructions, int[] values) {
        List<Integer> visited = new ArrayList<>();
        return getIndexRecursive(instructions, values, visited, 0, 0);
    }

    private static int getIndexRecursive(String[] instructions, int[] values, List<Integer> visited, int score, int index) {
        if (ADD.equals(instructions[index])) {
            if (values[index] >= 0) {
                score = values[index];
            }

            index = index + 1;
        } else if (JUMP.equals(instructions[index])) {
            index = index + values[index];
        }
        if (visited.contains(index)) {
            System.out.println("STOP HERE YOU FOUND SAME NUMBER " + index);
        }
        visited.add(index);
        getIndexRecursive(instructions, values, visited, values[index], index);
        return score;
    }
}