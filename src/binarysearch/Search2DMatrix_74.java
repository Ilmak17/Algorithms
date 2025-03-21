package binarysearch;

/*
 * LeetCode Problem 74: Search a 2D Matrix
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an m x n integer matrix with the following two properties:
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 */

public class Search2DMatrix_74 {

    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = n * m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int row = mid / m;
            int col = mid % m;

            if (mat[row][col] == target)
                return true;
            else if (mat[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }
}
