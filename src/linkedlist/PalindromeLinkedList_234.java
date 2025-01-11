package linkedlist;

/*
 * LeetCode Problem 234: Palindrome Linked List
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */

public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = head;
        ListNode reversedNode = reverse(slow);

        while (reversedNode != null) {
            if (reversedNode.val != cur.val) {
                return false;
            }

            reversedNode = reversedNode.next;
            cur = cur.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;
    }
}
