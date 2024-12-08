package greedy;

/*
 * LeetCode Problem 846: Hand of Straights
 * Difficulty: Medium
 *
 * Problem Statement:
 * Alice has some number of cards and she wants to rearrange the cards into groups so that each
 * group is of size groupSize, and consists of groupSize consecutive cards.
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize,
 *  return true if she can rearrange the cards, or false otherwise.
 */

import java.util.Map;
import java.util.TreeMap;

public class HandStraights_846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new TreeMap<>();

        for (int n : hand) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int card : map.keySet()) {
            int count = map.get(card);
            if (count > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int nextCard = card + i;
                    if (map.getOrDefault(nextCard, 0) < count) {
                        return false;
                    }
                    map.put(nextCard, map.get(nextCard) - count);
                }
            }
        }

        return true;
    }
}
