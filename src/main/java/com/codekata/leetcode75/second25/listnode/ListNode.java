package com.codekata.leetcode75.second25.listnode;

/**
 * The type List node.
 */
public class ListNode {

    /**
     * The Val.
     */
    int val;
    /**
     * The Next.
     */
    ListNode next;

    /**
     * Instantiates a new List node.
     */
    ListNode() { }

    /**
     * Instantiates a new List node.
     *
     * @param val the val
     */
    ListNode(int val) {
        this.val = val;
    }

    /**
     * Instantiates a new List node.
     *
     * @param val  the val
     * @param next the next
     */
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
