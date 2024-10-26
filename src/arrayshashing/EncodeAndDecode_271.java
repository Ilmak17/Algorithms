package arrayshashing;

/*
 * LeetCode Problem 271: String Encode and Decode
 * Difficulty: Medium
 *
 * Problem Statement:
 * Design an algorithm to encode a list of strings to a single string.
 *  The encoded string is then decoded back to the original list of strings.
 */

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode_271 {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }
}
