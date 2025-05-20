package linkedlist;

/*
 * LeetCode Problem 92: Reverse Linked List II
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the head of a singly linked list and two integers left and
 * right where left <= right, reverse the nodes of the list from position left to position right,
 *  and return the reversed list.
 */

public class ReverseLinkedListII_92 {

    public ListNode reverseBetween(ListNode head, int p, int q) {
        if (head == null || p == q)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 0; i < p - 1; i++) {
            prev = prev.next;
        }

        ListNode lastNodeBeforeSublist = prev;
        ListNode lastNodeOfSublist = prev.next;
        ListNode cur = prev.next;
        ListNode next = null;

        for (int i = 0; i < q - p + 1; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        lastNodeBeforeSublist.next = prev;
        lastNodeOfSublist.next = cur;

        return dummy.next;
    }
}
