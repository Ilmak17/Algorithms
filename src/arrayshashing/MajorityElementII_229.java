package arrayshashing;

/*
 * LeetCode Problem 36: Valid Sudoku
 * Difficulty: Medium
 *
 * Problem Statement:
 * Determine if a 9 x 9 Sudoku board is valid.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MajorityElementII_229 {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int key : count.keySet()) {
            if (count.get(key) > nums.length / 3) {
                res.add(key);
            }
        }

        return res;
    }
}
