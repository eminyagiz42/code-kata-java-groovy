package com.codekata.hackerrank.java;

import java.util.*;


public class DequeProblem {

    // https://www.hackerrank.com/challenges/java-dequeue/problem

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> freqs = new HashMap<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int ans = 0, countDistinct = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            freqs.putIfAbsent(num, 0);

            freqs.put(num, freqs.get(num) + 1);
            if (freqs.get(num) == 1) {
                countDistinct++;
            }

            if (deque.size() == m + 1) {
                int rem = deque.removeFirst();
                freqs.put(rem, freqs.get(rem) - 1);
                if (freqs.get(rem) == 0) {
                    countDistinct--;
                }
            }
            if (deque.size() == m) {
                if (countDistinct > ans) {
                    ans = countDistinct;
                }
            }
        }
        in.close();


        System.out.println(ans);
    }
}
