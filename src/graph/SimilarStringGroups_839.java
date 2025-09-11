package graph;

/*
 * LeetCode Problem 839: Similar String Groups
 * Difficulty: Hard
 *
 * Problem Statement:
 * Two strings, X and Y, are considered similar if either they are identical or we can make them equivalent
 * by swapping at most two letters (in distinct positions) within the string X.
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar,
 *  but "star" is not similar to "tars", "rats", or "arts".
 * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars"
 *  and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word
 * is in the group if and only if it is similar to at least one other word in the group.
 * We are given a list strs of strings where every string in strs is an anagram of every other string in strs.
 *  How many groups are there?
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimilarStringGroups_839 {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }

        Set<Integer> groups = new HashSet<>();

        for (int i = 0; i < n; i++) {
            groups.add(uf.find(i));
        }

        return groups.size();
    }

    private boolean isSimilar(String a, String b) {
        if (a.length() != b.length())
            return false;

        List<Integer> diff = new ArrayList<>();

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff.add(i);
                if (diff.size() > 2)
                    return false;
            }
        }

        if (diff.isEmpty())
            return true;
        if (diff.size() != 2)
            return false;

        int i = diff.get(0), j = diff.get(1);
        return a.charAt(i) == b.charAt(j) && a.charAt(j) == b.charAt(i);
    }
}
