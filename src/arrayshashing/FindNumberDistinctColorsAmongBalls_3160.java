package arrayshashing;

/*
 * LeetCode Problem 3160. Find the Number of Distinct Colors Among the Balls
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an integer limit and a 2D array queries of size n x 2.
 * There are limit + 1 balls with distinct labels in the range [0, limit]. Initially, all balls are uncolored.
 *  For every query in queries that is of the form [x, y], you mark ball x with the color y. After each query,
 *  you need to find the number of distinct colors among the balls.
 * Return an array result of length n, where result[i] denotes the number of distinct colors after ith query.
 * Note that when answering a query, lack of a color will not be considered as a color.
 */


import java.util.HashMap;
import java.util.Map;

public class FindNumberDistinctColorsAmongBalls_3160 {
    public int[] queryResults(int limit, int[][] queries) {
        int[] res = new int[queries.length];
        int i = 0;

        Map<Integer, Integer> balls = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();

        for (int[] query : queries) {
            int ball = query[0];
            int color = query[1];

            if (balls.containsKey(ball)) {
                Integer colorToRemove = balls.get(ball);
                colorCount.put(colorToRemove, colorCount.get(colorToRemove) - 1);
                if (colorCount.get(colorToRemove) == 0) {
                    colorCount.remove(colorToRemove);
                }
            }

            balls.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);

            res[i++] = colorCount.size();
        }

        return res;
    }
}
