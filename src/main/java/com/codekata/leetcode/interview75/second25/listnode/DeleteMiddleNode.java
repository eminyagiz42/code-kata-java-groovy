package com.codekata.leetcode.interview75.second25.listnode;

/**
 * The type Delete middle node.
 */
public class DeleteMiddleNode {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list

        printList(deleteMiddle(createListNode())); // 1,3,4,7,1,2,6
    }

    /**
     * Delete middle list node.
     *
     * @param head the head
     * @return the list node
     */
    public static ListNode deleteMiddle(ListNode head) {
        int middle = getLength(head)  / 2 ;
        return deleteNode(head, middle);
    }

    /**
     * Delete node list node.
     *
     * @param head   the head
     * @param middle the middle
     * @return the list node
     */
    public static ListNode deleteNode(ListNode head, int middle) {
        if (head == null)
            return null;
        if (head.next == null) {
            return null;
        }
        ListNode temp = head;
        while (middle > 1) {
            middle--;
            head = head.next;
        }
        head.next = head.next.next;

        return temp;
    }

    /**
     * Gets length.
     *
     * @param head the head
     * @return the length
     */
    public static int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    /**
     * Print list.
     *
     * @param head the head
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("NULL");
    }

    private static ListNode createListNode() {
        ListNode listNode3 = new ListNode();
        listNode3.val = 4;
        listNode3.next = null;

        ListNode listNode2 = new ListNode();
        listNode2.val = 3;
        listNode2.next = listNode3;

        ListNode listNode1 = new ListNode();
        listNode1.val = 2;
        listNode1.next = listNode2;

        ListNode listNode0 = new ListNode();
        listNode0.val = 1;
        listNode0.next = listNode1;
        return listNode0;
    }

    private static ListNode createListNode0() {
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(2, node6);
        ListNode node4 = new ListNode(1, node5);
        ListNode node3 = new ListNode(7, node4);
        ListNode node2 = new ListNode(4, node3);
        ListNode node1 = new ListNode(3, node2);
        ListNode head = new ListNode(1, node1);
        return head;
    }
}
