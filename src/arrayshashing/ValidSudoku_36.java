package arrayshashing;

/*
 * LeetCode Problem 36: Valid Sudoku
 * Difficulty: Medium
 *
 * Problem Statement:
 * Determine if a 9 x 9 Sudoku board is valid.
 */


import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        Set<String> rows = new HashSet<>();
        HashSet<String> columns = new HashSet<>();
        HashSet<String> boxes = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    String rowKey = "row" + i + "(" + num + ")";
                    String colKey = "col" + j + "(" + num + ")";
                    String boxKey = "box" + (i / 3 * 3 + j / 3) + "(" + num + ")";
                    if (!rows.add(rowKey) || !columns.add(colKey) || !boxes.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
