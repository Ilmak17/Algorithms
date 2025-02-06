package arrayshashing;

/*
 * LeetCode Problem 1726: Tuple with Same Product
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d)
 * such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.
 */


import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct_1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int result = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                int count = productCount.getOrDefault(product, 0);
                result += count * 8;
                productCount.put(product, count + 1);
            }
        }

        return result;
    }
}
