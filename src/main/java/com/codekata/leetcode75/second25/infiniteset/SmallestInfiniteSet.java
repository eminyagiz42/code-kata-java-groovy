package com.codekata.leetcode75.second25.infiniteset;

import java.util.PriorityQueue;

class SmallestInfiniteSet {

    private final PriorityQueue<Integer> priorityQueue;
    private int current;

    public SmallestInfiniteSet() {
        this.priorityQueue = new PriorityQueue<>();
        this.current = 1;
    }

    public int popSmallest() {
        int result = current;
        if (!priorityQueue.isEmpty() && priorityQueue.peek() < current) {
            result = priorityQueue.poll();
        } else {
            current++;
        }
        while (!priorityQueue.isEmpty() && priorityQueue.peek() == result) {
            priorityQueue.poll();
        }
        return result;
    }

    public void addBack(int num) {
        priorityQueue.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */