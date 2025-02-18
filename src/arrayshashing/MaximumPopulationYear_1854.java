package arrayshashing;

/*
 * LeetCode Problem 1854: Maximum Population Year
 * Difficulty: Easy
 *
 * Problem Statement:
 * You are given a 2D integer array logs where each logs[i] = [birthi, deathi]
 * indicates the birth and death years of the ith person.
 * The population of some year x is the number of people alive during that year.
 * The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1].
 * Note that the person is not counted in the year that they die.
 * Return the earliest year with the maximum population.
 */

public class MaximumPopulationYear_1854 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    private void rotate(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
}
