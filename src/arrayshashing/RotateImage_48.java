package arrayshashing;

/*
 * LeetCode Problem 48: Rotate Image
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */

public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;
        while (l < r) {
            for(int i = 0; i < r - l; i++) {
                int topLeft = matrix[l][l + i];

                matrix[l][l + i] = matrix[r - i][l];
                matrix[r - i][l] = matrix[r][r - i];
                matrix[r][r - i] = matrix[l + i][r];
                matrix[l + i][r] = topLeft;
            }
            r--;
            l++;
        }
    }
}
