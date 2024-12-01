package graph;

/*
 * LeetCode Problem 994: Rotting Oranges
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_994 {
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> q = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Integer[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean isInfected = false;

            for (int i = 0; i < size; i++) {
                Integer[] node = q.poll();
                for (int[] direction : directions) {
                    int nr = node[0] + direction[0];
                    int nc = node[1] + direction[1];

                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new Integer[]{nr, nc});
                        freshCount--;
                        isInfected = true;
                    }
                }
            }

            if (isInfected) {
                time++;
            }
        }

        return freshCount == 0 ? time : -1;
    }
}
