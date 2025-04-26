package graph;

/*
 * LeetCode Problem 1631: Path With Minimum Effort
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
 * where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0),
 *  and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).
 * You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort_1631 {
    public int minimumEffortPath(int[][] heights) {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.add(new int[]{0, 0, 0});

        int r = heights.length;
        int c = heights[0].length;
        int[][] minEffort = new int[r][c];

        for (int[] row : minEffort) Arrays.fill(row, Integer.MAX_VALUE);
        minEffort[0][0] = 0;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int effort = cur[0];
            int x = cur[1];
            int y = cur[2];

            if (x == r - 1 && y == c - 1) return effort;

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < r && newY >= 0 && newY < c) {
                    int currentDiff = Math.abs(heights[newX][newY] - heights[x][y]);
                    int maxDiff = Math.max(effort, currentDiff);

                    if (maxDiff < minEffort[newX][newY]) {
                        minEffort[newX][newY] = maxDiff;
                        queue.offer(new int[]{maxDiff, newX, newY});
                    }
                }
            }
        }

        return 0;
    }
}
