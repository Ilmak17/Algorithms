package arrayshashing;

/*
 * LeetCode Problem 202: Happy Number
 * Difficulty: Easy
 *
 * Problem Statement:
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */

public class HappyNumber_202 {
    public boolean isHappy(int num) {
        int fast = num;
        int slow = num;

        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while (fast != slow);

        return slow == 1;
    }

    private int findSquareSum(int num) {
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}
