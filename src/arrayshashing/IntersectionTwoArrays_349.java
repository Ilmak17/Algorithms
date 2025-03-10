package arrayshashing;

/*
 * LeetCode Problem 349: Intersection of Two Arrays
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> seen = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int x : nums1) {
            seen.put(x, 1);
        }

        for (int x : nums2) {
            if (seen.containsKey(x) && seen.get(x) == 1) {
                result.add(x);
                seen.put(x, 0);
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}
