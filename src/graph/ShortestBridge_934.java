package graph;

/*
 * LeetCode Problem 934: Shortest Bridge
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 * An island is a 4-directionally connected group of 1's not connected to any other 1's.
 * There are exactly two islands in grid.
 * You may change 0's to 1's to connect the two islands to form one island.
 * Return the smallest number of 0's you must flip to connect the two islands.
 */

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge_934 {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, queue, i, j);
                    found = true;
                    break;
                }
            }
        }

        int steps = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : directions) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            return steps;
                        }
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private void dfs(int[][] grid, boolean[][] visited, Queue<int[]> queue, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        dfs(grid, visited, queue, i + 1, j);
        dfs(grid, visited, queue, i - 1, j);
        dfs(grid, visited, queue, i, j + 1);
        dfs(grid, visited, queue, i, j - 1);
    }
}
