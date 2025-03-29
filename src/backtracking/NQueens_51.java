package backtracking;

/*
 * LeetCode Problem 51: N-Queens
 * Difficulty: Hard
 *
 * Problem Statement:
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens_51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(board, 0, res);

        return res;
    }

    private void backtrack(char[][] board, int row, List<List<String>> res) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(new String(chars));
            }
            res.add(list);
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (canPlace(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, res);
                board[row][col] = '.';
            }
        }
    }

    private boolean canPlace(char[][] board, int r, int c) {
        int nr, nc;

        nr = r - 1;
        nc = c - 1;
        while (nr >= 0 && nc >= 0) {
            if (board[nr][nc] == 'Q')
                return false;
            nr--;
            nc--;
        }

        nr = r - 1;
        while (nr >= 0) {
            if (board[nr][c] == 'Q')
                return false;
            nr--;
        }

        nr = r - 1;
        nc = c + 1;
        while (nr >= 0 && nc < board.length) {
            if (board[nr][nc] == 'Q')
                return false;
            nr--;
            nc++;
        }

        return true;
    }
}
