package graph;

/*
 * LeetCode Problem 130: Surrounded Regions
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells
 *  and none of the region cells are on the edge of the board.
 * A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.
 */

public class SurroundedRegions_130 {
    private final int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;123

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'U') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        board[r][c] = 'U';
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (Math.min(nr, nc) < 0 || nr >= board.length
                    || nc >= board[0].length || board[nr][nc] != 'O') {
                continue;
            }

            dfs(board, nr, nc);
        }
    }
}
