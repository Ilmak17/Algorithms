package graph;

/*
 * LeetCode Problem 864: Shortest Path to Get All Keys
 * Difficulty: Hard
 *
 * Problem Statement:
 * You are given an m x n grid grid where:
 * '.' is an empty cell.
 * '#' is a wall.
 * '@' is the starting point.
 * Lowercase letters represent keys.
 * Uppercase letters represent locks.
 * You start at the starting point and one move consists of walking one space in one of the four cardinal directions. You cannot walk outside the grid, or walk into a wall.
 * If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.
 * For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the English alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
 * Return the lowest number of moves to acquire all keys. If it is impossible, return -1.
 */


import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathGetAllKeys_864 {
    public int shortestPathAllKeys(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        int totalKeys = 0;
        int startRow = 0, startCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    startRow = i;
                    startCol = j;
                } else if (ch >= 'a' && ch <= 'f') {
                    totalKeys |= (1 << (ch - 'a'));
                }
            }
        }

        boolean[][][] visited = new boolean[rows][cols][64];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startRow, startCol, 0, 0 }); // row, col, keys, steps
        visited[startRow][startCol][0] = true;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int keys = cur[2];
            int steps = cur[3];

            if (keys == totalKeys)
                return steps;

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                int newKeys = keys;

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols)
                    continue;

                char ch = grid[newRow].charAt(newCol);

                if (ch == '#')
                    continue;

                if (ch >= 'A' && ch <= 'F') {
                    if ((keys & (1 << (ch - 'A'))) == 0)
                        continue;
                }

                if (ch >= 'a' && ch <= 'f') {
                    newKeys |= (1 << (ch - 'a'));
                }

                if (visited[newRow][newCol][newKeys])
                    continue;

                visited[newRow][newCol][newKeys] = true;
                queue.add(new int[] { newRow, newCol, newKeys, steps + 1 });
            }
        }

        return -1;
    }
}
