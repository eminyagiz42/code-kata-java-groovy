package leetcode.ListNodes;

public class OddEvenListNode {

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

        //https://leetcode.com/problems/odd-even-linked-list/

        printList(oddEvenList(createListNode())); //2 4 2 4 2 4 2 output: 2 2 2 2 4 4 4
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        int[] values = splitOddEvenIndex(getValues(head, length));

        ListNode temp = head;
        for (int v :values) {
            head.val = v;
            head = head.next;
        }
        return temp;
    }

    public static int[] splitOddEvenIndex(int[] values) {
        final int length = values.length;
        int[] evenValues = new int[length / 2];
        int indexOdd = 0;
        int indexEven = 0;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                values[indexOdd++] = values[i];
            } else {
                evenValues[indexEven++] = values[i];
            }
        }
        for (int i = 0; i < length / 2; i++) {
             values[indexOdd++] = evenValues[i];
        }
        return values;
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
        ListNode node6 = new ListNode(2);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(4, node2);
        return new ListNode(2, node1);
    }
}
