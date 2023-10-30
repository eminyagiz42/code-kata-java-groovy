package leetcode.deletemiddle;

public class DeleteMiddleNode {

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
        //https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list

        printList(deleteMiddle(createListNode())); // 1,3,4,7,1,2,6
    }

    public static CustomListNode deleteMiddle(CustomListNode head) {
        int middle = getLength(head)  / 2 ;
        return deleteNode(head, middle);
    }

    public static CustomListNode deleteNode(CustomListNode head, int middle) {
        if (head == null)
            return null;
        if (head.next == null) {
            return null;
        }
        CustomListNode temp = head;
        while (middle > 1) {
            middle--;
            head = head.next;
        }
        head.next = head.next.next;

        return temp;
    }

    public static int getLength(CustomListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static void printList(CustomListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("NULL");
    }

    private static CustomListNode createListNode() {
        CustomListNode customListNode3 = new CustomListNode();
        customListNode3.val = 4;
        customListNode3.next = null;

        CustomListNode customListNode2 = new CustomListNode();
        customListNode2.val = 3;
        customListNode2.next = customListNode3;

        CustomListNode customListNode1 = new CustomListNode();
        customListNode1.val = 2;
        customListNode1.next = customListNode2;

        CustomListNode customListNode0 = new CustomListNode();
        customListNode0.val = 1;
        customListNode0.next = customListNode1;
        return customListNode0;
    }

    private static CustomListNode createListNode0() {
        CustomListNode node6 = new CustomListNode(6);
        CustomListNode node5 = new CustomListNode(2, node6);
        CustomListNode node4 = new CustomListNode(1, node5);
        CustomListNode node3 = new CustomListNode(7, node4);
        CustomListNode node2 = new CustomListNode(4, node3);
        CustomListNode node1 = new CustomListNode(3, node2);
        CustomListNode head = new CustomListNode(1, node1);
        return head;
    }
}
