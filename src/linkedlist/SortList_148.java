package linkedlist;

/*
 * LeetCode Problem 148: Sort List
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the head of a linked list, return the list after sorting it in ascending order.
 */

public class SortList_148 {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode prev = null;
        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        return merge(mergeSort(node), mergeSort(slow));
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        }

        if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }
}
