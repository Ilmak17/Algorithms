package graph;

/*
 * LeetCode Problem 463: Island Perimeter
 * Difficulty: Easy
 *
 * Problem Statement:
 * You are given row x col grid representing a map where grid[i][j] = 1
 * represents land and grid[i][j] = 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 */

public class IslandPerimeter_463 {
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
            return 1;

        if (grid[r][c] == 0)
            return 1;

        if (grid[r][c] != 1)
            return 0;

        grid[r][c] = -1;

        int perimeter = 0;
        for (int[] dir : DIRECTIONS)
            perimeter += dfs(grid, r + dir[0], c + dir[1]);

        return perimeter;
    }
}