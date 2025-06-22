package dp;

/*
 * LeetCode Problem 343: Integer Break
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize
 * the product of those integers.
 * Return the maximum product you can get.
 */

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak_343 {
    private Map<Integer, Integer> dp;

    public int integerBreak(int n) {
        dp = new HashMap<>();
        dp.put(1, 1);
        return dfs(n, n);
    }

    private int dfs(int num, int n) {
        if (dp.containsKey(num)) {
            return dp.get(num);
        }

        int res = (num == n) ? 0 : num;
        for (int i = 1; i < num; i++) {
            int val = dfs(i, n) * dfs(num - i, n);
            res = Math.max(res, val);
        }

        dp.put(num, res);
        return res;
    }
}
