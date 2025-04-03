package linkedlist;

/*
 * LeetCode Problem 61: Rotate List
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the head of a linked list, rotate the list to the right by k places.
 */

public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        k %= len;

        if (k == 0) return head;

        tail.next = head;

        ListNode cur = head;

        for (int i = 0; i < len - k - 1; i++) {
            cur = cur.next;
        }

        ListNode newTail = cur.next;
        cur.next = null;

        return newTail;
    }
}
