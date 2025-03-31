package linkedlist;

/*
 * LeetCode Problem 328. Odd Even Linked List
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by
 *  the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 */

public class OddEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = firstEven;

        return head;
    }
}
