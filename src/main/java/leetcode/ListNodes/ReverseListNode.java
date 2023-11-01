package leetcode.ListNodes;

public class ReverseListNode {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static void main(String[] args) {

        //https://leetcode.com/problems/reverse-linked-list

        printList(reverseList(createListNode0())); // 1,3,4,7,1,2,6
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        int[] values = reverse(getValues(head, length));

        ListNode temp = head;
        for (int v :values) {
            head.val = v;
            head = head.next;
        }
        return temp;
    }

    public static int[] reverse(int[] validData) {
        for (int i = 0; i < validData.length / 2; i++) {
            int temp = validData[i];
            validData[i] = validData[validData.length - i - 1];
            validData[validData.length - i - 1] = temp;
        }
        return validData;
    }

    public static int[] getValues(ListNode head, int length) {
        int[] values = new int[length];
        int index = 0;
        while (head != null) {
            values[index++] = head.val;
            head = head.next;
        }
        return values;
    }

    public static int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

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
        return new ListNode(1, node1);
    }
}
