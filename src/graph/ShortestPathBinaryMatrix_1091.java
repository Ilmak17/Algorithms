package graph;

/*
 * LeetCode Problem 1091. Shortest Path in Binary Matrix
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0))
 * to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 */

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix_1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{0, 0, 1});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        while(!q.isEmpty()) {
            Integer[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int length = curr[2];

            if (Math.min(r, c) < 0 || Math.max(r, c) > n || grid[r][c] == 1) continue;

            if (r == n - 1 && c == n - 1) return length;

            for (int[] d : direct) {
                int newRow = r + d[0];
                int newCol = c + d[1];
                if (Math.min(newRow, newCol) >= 0 && Math.max(newRow, newCol) < n
                        && !visited[newRow][newCol]) {
                    q.add(new Integer[]{newRow, newCol, 1 + length});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }
}
