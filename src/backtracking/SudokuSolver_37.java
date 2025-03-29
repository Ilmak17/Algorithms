package backtracking;

/*
 * LeetCode Problem 37: Sudoku Solver
 * Difficulty: Medium
 *
 * Problem Statement:
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 */

public class SudokuSolver_37 {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isSafe(board, i, j, num)) {
                            board[i][j] = num;
                            boolean res = solveSudokuHelper(board);
                            if (res) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isSafe(char[][] board, int r, int c, int n) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == n) return false;
        }

        for (int j = 0; j < 9; j++) {
            if (board[r][j] == n) return false;
        }

        int startRow = 3 * (r / 3);
        int startCol = 3 * (c / 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == n) return false;
            }
        }

        return true;
    }
}
