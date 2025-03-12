package arrayshashing;

/*
 * LeetCode Problem 169: Majority Element
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 *  You may assume that the majority element always exists in the array.
 */

public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int res = 0;
        int counter = 0;

        for (int el : nums) {
            if (counter == 0) {
                res = el;
            }
            counter += el == res ? 1 : -1;
        }

        return res;
    }
}
