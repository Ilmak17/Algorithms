package arrayshashing;

/*
 * LeetCode Problem 54: Spiral Matrix
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                res.add(matrix[startRow][i]);

            }
            for (int j = startRow + 1; j <= endRow; j++) {
                res.add(matrix[j][endCol]);
            }

            for (int k = endCol - 1; k >= startCol; k--) {
                if (startRow == endRow) break;
                res.add(matrix[endRow][k]);
            }

            for (int l = endRow - 1; l > startRow; l--) {
                if (startCol == endCol) break;
                res.add(matrix[l][startCol]);
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }


        return res;
    }
}
