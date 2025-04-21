package linkedlist;

/*
 * LeetCode Problem 369: Plus One Linked List
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a non-negative integer represented as a linked list of digits, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list.
 */

public class PlusOneLinkedList_369 {
    public ListNode plusOne(ListNode head) {
        int carry = addHelper(head);

        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    private int addHelper(ListNode head) {
        if (head == null) return 1;
        int val = addHelper(head.next);

        head.val += val;

        if (head.val < 10) return 0;

        head.val = 0;

        return 1;
    }
}
