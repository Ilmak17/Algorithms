package linkedlist;

/*
 * LeetCode Problem 160: Intersection of Two Linked Lists
 * Difficulty: Easy
 *
 * Problem Statement:
 * Intersection of Two Linked Lists
 */

public class IntersectionTwoLinkedLists_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode d1 = headA;
        ListNode d2 = headB;

        while (d1 != d2) {
            d1 = d1.next;
            d2 = d2.next;

            if (d1 == d2)
                return d1;

            if (d1 == null)
                d1 = headB;
            if (d2 == null)
                d2 = headA;
        }

        return d1;
    }
}
