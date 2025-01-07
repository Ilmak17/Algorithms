package twopointers;

/*
 * LeetCode Problem 443: String Compression
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead,
 * be stored in the input character array chars. Note that group lengths
 *  that are 10 or longer will be split into multiple characters in chars.
 * After you are done modifying the input array, return the new length of the array.
 * You must write an algorithm that uses only constant extra space.
 */

public class StringCompression_443 {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;
        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            chars[write++] = currentChar;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
