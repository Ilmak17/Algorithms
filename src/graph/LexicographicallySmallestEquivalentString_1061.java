package graph;

/*
 * LeetCode Problem 1061: Lexicographically Smallest Equivalent String
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 */

public class LexicographicallySmallestEquivalentString_1061 {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int len = s1.length();
        UnionFind uf = new UnionFind(26);

        for (int i = 0; i < len; i++) {
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder builder = new StringBuilder();

        for (char ch : baseStr.toCharArray()) {
            int rep = uf.find(ch - 'a');
            builder.append((char)(rep + 'a'));
        }

        return builder.toString();
    }
}
