package arrayshashing;

/*
 * LeetCode Problem 380: Insert Delete GetRandom O(1)
 * Difficulty: Medium
 *
 * Problem Statement:
 * Implement the RandomizedSet class:
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present.
 *  Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present.
 *  Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements
 *  (it's guaranteed that at least one element exists when this method is called).
 * Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom_380 {
    private final Map<Integer, Integer> map;
    private final List<Integer> nums;
    private final Random random;

    public InsertDeleteGetRandom_380() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        nums.add(val);
        map.put(val, nums.size() - 1);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastEl = nums.get(nums.size() - 1);

        nums.set(index, lastEl);
        map.put(lastEl, index);

        nums.remove(nums.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
