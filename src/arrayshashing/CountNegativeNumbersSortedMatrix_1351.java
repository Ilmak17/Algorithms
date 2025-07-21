package arrayshashing;

/*
 * LeetCode Problem 1351: Count Negative Numbers in a Sorted Matrix
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
 * return the number of negative numbers in grid.
 */

public class CountNegativeNumbersSortedMatrix_1351 {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int row = 0, col = n - 1;
        int count = 0;

        while (row < m && col >= 0) {
            if (grid[row][col] < 0) {
                count += (m - row);
                col--;
            } else {
                row++;
            }
        }

        return count;
    }
}
