package graph;

/*
 * LeetCode Problem 1267: Count Servers that Communicate
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a map of a server center,
 *  represented as a m * n integer matrix grid, where 1 means that
 * on that cell there is a server and 0 means that it is no server.
 *  Two servers are said to communicate if they are on the same row or on the same column.
 */

public class CountServersThatCommunicate_1267 {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}
