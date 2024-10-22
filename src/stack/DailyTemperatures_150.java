package stack;

/*
 * LeetCode Problem 739: Daily Temperatures
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days
 * you have to wait after the ith day to get a warmer temperature.
 *  If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */


public class DailyTemperatures_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }

        return res;
    }
}
