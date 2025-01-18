package tree;

/*
 * LeetCode Problem 109: Convert Sorted List to Binary Search Tree
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 */

import linkedlist.ListNode;

public class ConvertSortedListToBinarySearchTree_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);

        prev.next = null;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}
