package arrayshashing;

/*
 * LeetCode Problem 229: Majority Element II
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 */

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII_229 {

    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = 0;
        int el2 = 0;

        for (int n : nums) {
            if (cnt1 == 0 && n != el2) {
                cnt1++;
                el1 = n;
            } else if (cnt2 == 0 && n != el1) {
                cnt2++;
                el2 = n;
            } else if (n == el1) {
                cnt1++;
            } else if (n == el2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for (int n : nums) {
            if (n == el1) {
                cnt1++;
            } else if (n == el2) {
                cnt2++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (cnt1 > nums.length / 3) res.add(el1);
        if (cnt2 > nums.length / 3) res.add(el2);

        return res;
    }
}
