package arrayshashing;

/*
 * LeetCode Problem 118: Pascal's Triangle
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            pascalTriangle.add(generateRow(row));
        }

        return pascalTriangle;
    }

    private List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();

        ansRow.add(1);

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }

        return ansRow;
    }
}
