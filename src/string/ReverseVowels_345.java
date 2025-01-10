package string;

/*
 * LeetCode Problem 345: Reverse Vowels of a String
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given a string s, reverse only all the vowels in the string and return it.
 */

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels_345 {
    private final Set<Character> set = new HashSet<>();

    public ReverseVowels_345() {
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');
    }

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;

        char[] chars = s.toCharArray();

        while (i < j) {
            if (!set.contains(chars[i])) {
                i++;
            } else if (!set.contains(chars[j])) {
                j--;
            } else {
                swap(chars, i, j);
                i++;
                j--;
            }
        }

        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
