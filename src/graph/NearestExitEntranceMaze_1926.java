package graph;

/*
 * LeetCode Problem 1926: Nearest Exit from Entrance in Maze
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+').
 *  You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes
 * the row and column of the cell you are initially standing at.
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall,
 * and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined
 * as an empty cell that is at the border of the maze. The entrance does not count as an exit.
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 */


import java.util.Queue;

public class NearestExitEntranceMaze_1926 {
    private final static int[][] DIRS = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        int startRow = entrance[0];
        int startCol = entrance[1];

        queue.add(new int[] { startRow, startCol, 0 });
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int steps = cur[2];

            if ((row == 0 || row == m - 1 || col == 0 || col == n - 1)
                    && !(row == startRow && col == startCol)) {
                return steps;
            }

            for (int[] dir : DIRS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                        maze[newRow][newCol] == '.' && !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    queue.add(new int[] { newRow, newCol, steps + 1 });
                }
            }
        }

        return -1;
    }
}