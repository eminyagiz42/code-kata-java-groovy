package com.codekata.leetcode75.third25;

import java.util.PriorityQueue;
import java.util.Queue;

public class TotalCostHire {

    public static void main(String[] args) {

        //https://leetcode.com/problems/total-cost-to-hire-k-workers/

        int[] costs = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k = 3, candidates = 4;
        System.out.println(totalCost(costs, k, candidates));
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        long result = 0;
        int i = 0;
        int j = costs.length - 1;
        Queue<Integer> minHeapL = new PriorityQueue<>();
        Queue<Integer> minHeapR = new PriorityQueue<>();

        for (int hired = 0; hired < k; ++hired) {
            while (minHeapL.size() < candidates && i <= j) {
                minHeapL.offer(costs[i++]);
            }
            while (minHeapR.size() < candidates && i <= j) {
                minHeapR.offer(costs[j--]);
            }
            if (minHeapL.isEmpty()) {
                result += minHeapR.poll();
            } else if (minHeapR.isEmpty()) {
                result += minHeapL.poll();
            } else if (minHeapL.peek() <= minHeapR.peek()) {
                result += minHeapL.poll();
            } else {
                result += minHeapR.poll();
            }
        }
        return result;
    }
}