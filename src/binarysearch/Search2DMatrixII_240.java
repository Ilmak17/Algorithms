package binarysearch;

/*
 * LeetCode Problem 240: Search a 2D Matrix II
 * Difficulty: Medium
 *
 * Problem Statement:
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */

public class Search2DMatrixII_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int val = matrix[row][col];

            if (val == target) {
                return true;
            } else if (val > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
