package arrayshashing;

/*
 * LeetCode Problem 119: Pascal's Triangle II
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long value = 1;
        ans.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            value = value * (rowIndex - i + 1) / i;
            ans.add((int) value);
        }

        return ans;
    }
}
