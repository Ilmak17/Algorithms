package linkedlist;

/*
 * LeetCode Problem 141: Linked List Cycle
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 */

public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}
