package backtracking;

/*
 * LeetCode Problem 79: Word Search
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */

public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && isWordExist(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isWordExist(char[][] board, String word, int idx, int r, int c) {
        if (idx == word.length()) {
            return true;
        }
        if (r >= board.length || c >= board[0].length || r < 0 || c < 0) {
            return false;
        }

        if (word.charAt(idx) != board[r][c]) {
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '0';

        boolean found = isWordExist(board, word, idx + 1, r + 1, c) ||
                isWordExist(board, word, idx + 1, r - 1, c) ||
                isWordExist(board, word, idx + 1, r, c + 1) ||
                isWordExist(board, word, idx + 1, r, c - 1);
        board[r][c] = temp;

        return found;
    }
}
