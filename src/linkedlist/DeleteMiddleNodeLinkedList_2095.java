package linkedlist;

/*
 * LeetCode Problem 2095: Delete the Middle Node of a Linked List
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing,
 * where ⌊x⌋ denotes the largest integer less than or equal to x.
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 */

public class DeleteMiddleNodeLinkedList_2095 {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null)  {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        prev.next = slow.next;

        return head;
    }
}
