package linkedlist;

/*
 * LeetCode Problem 21: Merge Two Sorted Lists
 * Difficulty: Easy
 *
 * Problem Statement:
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together
 * the nodes of the first two lists.
 * Return the head of the merged linked list.
 */

public class MergeTwoSortedLists_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode prev = root;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                prev.next = list2;
                list2 = list2.next;
            } else {
                prev.next = list1;
                list1 = list1.next;
            }
            prev = prev.next;
        }

        prev.next = list1 == null ? list2 : list1;

        return root.next;
    }
}
