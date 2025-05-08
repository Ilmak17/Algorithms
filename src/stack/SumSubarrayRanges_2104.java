package stack;

/*
 * LeetCode Problem 2104: Sum of Subarray Ranges
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an integer array nums. The range of a subarray of nums is the difference between
 * the largest and smallest element in the subarray.
 * Return the sum of all subarray ranges of nums.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */


import java.util.Stack;

public class SumSubarrayRanges_2104 {
    public long subArrayRanges(int[] nums) {
        return sumSubarraysMax(nums) - sumSubarraysMin(nums);
    }

    private long sumSubarraysMin(int[] nums) {
        int[] arrNse = getNse(nums);
        int[] arrPse = getPse(nums);
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = i - arrPse[i];
            int right = arrNse[i] - i;
            long freq = (long) left * right;
            res = res + (freq * nums[i]);
        }

        return res;
    }

    private long sumSubarraysMax(int[] nums) {
        int[] arrNge = getNge(nums);
        int[] arrPge = getPge(nums);
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = i - arrPge[i];
            int right = arrNge[i] - i;
            long freq = (long) left * right;
            res = res + (freq * nums[i]);
        }

        return res;
    }

    private int[] getNse(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            res[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return res;
    }

    private int[] getPse(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return res;
    }

    private int[] getNge(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i])
                stack.pop();
            res[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return res;
    }

    private int[] getPge(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return res;
    }
}
