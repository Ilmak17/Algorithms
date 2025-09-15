package graph;

/*
 * LeetCode Problem 505: The Maze II
 * Difficulty: Medium
 *
 * Problem Statement:
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1).
 * The ball can go through the empty spaces by rolling up, down, left or right, but it
 * won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol]
 * and destination = [destinationrow, destinationcol], return the shortest distance for the ball to stop
 * at the destination. If the ball cannot stop at destination, return -1.
 * The distance is the number of empty spaces traveled by the ball from the start position (excluded)
 *  to the destination (included).
 * You may assume that the borders of the maze are all walls (see examples).
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheMazeII_505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;

        int[][] dist = new int[rows][cols];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[start[0]][start[1]] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, start[0], start[1]});

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], r = cur[1], c = cur[2];

            if (r == destination[0] && c == destination[1]) return cost;

            for (int[] dir : dirs) {
                int nr = r;
                int nc = c;
                int steps = 0;

                while (nr + dir[0] >= 0 && nr + dir[0] < rows &&
                        nc + dir[1] >= 0 && nc + dir[1] < cols &&
                        maze[nr + dir[0]][nc + dir[1]] == 0) {
                    nr += dir[0];
                    nc += dir[1];
                    steps++;
                }

                if (dist[nr][nc] > cost + steps) {
                    dist[nr][nc] = cost + steps;
                    pq.add(new int[]{dist[nr][nc], nr, nc});
                }
            }
        }

        return -1;
    }
}
