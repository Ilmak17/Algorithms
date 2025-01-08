package string;

/*
 * LeetCode Problem 67: Add Binary
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given two binary strings a and b, return their sum as a binary string.
 */

public class AddBinary_67 {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            builder.append(sum % 2);

            carry = sum / 2;
        }

        return builder.reverse().toString();
    }
}
