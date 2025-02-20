package queue;

/*
 * LeetCode Problem 2944: Minimum Number of Coins for Fruits
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an 0-indexed integer array prices where prices[i] denotes the number of coins needed to purchase the (i + 1)th fruit.
 * The fruit market has the following reward for each fruit:
 * If you purchase the (i + 1)th fruit at prices[i] coins, you can get any number of the next i fruits for free.
 * Note that even if you can take fruit j for free, you can still purchase it for prices[j - 1] coins to receive its reward.
 * Return the minimum number of coins needed to acquire all the fruits.
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MinimumNumberCoinsFruits_2944 {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(n);
        prices = Arrays.copyOf(prices, n + 1);
        prices[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int maxCoveredIndex = Math.min(n, 2 * i + 2);

            while (!deque.isEmpty() && deque.peekFirst() > maxCoveredIndex) {
                deque.pollFirst();
            }
            prices[i] += prices[deque.peekFirst()];

            while (!deque.isEmpty() && prices[i] < prices[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return prices[0];
    }
}
