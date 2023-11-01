package leetcode.listnode;

public class PairSumListNode {

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

        // https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list

        System.out.println(pairSum(createListNode())); // 5,4,2,1
    }

    public static int pairSum(ListNode head) { //7ms
        if (head == null) {
            return 0;
        }
        int[] values = getValues(head, getLength(head));
        int saved = 0;
        for (int i = 0; i < values.length / 2; i++) {
            int sum = values[values.length - 1 - i] + values[i];
            if (saved == 0) {
                saved = sum;
            }
            saved = Math.max(sum, saved);
        }
       return saved;
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

    private static ListNode createListNode() {
        ListNode node3 = new ListNode(5, null);
        ListNode node2 = new ListNode(4, node3);
        ListNode node1 = new ListNode(2, node2);
        return new ListNode(1, node1);
    }
}
