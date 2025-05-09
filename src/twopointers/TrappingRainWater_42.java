package twopointers;

/*
 * LeetCode Problem 42: Trapping Rain Water
 * Difficulty: Hard
 *
 * Problem Statement:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.y.
 */

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int total = 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                total += leftMax - height[left++];
                continue;
            }
            rightMax = Math.max(height[right], rightMax);
            total += rightMax - height[right--];
        }

        return total;
    }
}
