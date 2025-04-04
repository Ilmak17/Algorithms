package linkedlist;

/*
 * LeetCode Problem 19: Remove Nth Node From End of List
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */

public class RemoveNthNodeFromEndOfList_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        cur = dummyHead;
        for (int i = 0; i < length - n; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return dummyHead.next;
    }
}
