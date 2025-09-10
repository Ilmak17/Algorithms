package graph;

/*
 * LeetCode Problem 990: Satisfiability of Equality Equations
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an array of strings equations that represent relationships
 * between variables where each string equations[i] is of length 4 and takes
 * one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase
 * letters (not necessarily different) that represent one-letter variable names.
 * Return true if it is possible to assign integers to variable names so as to satisfy
 * all the given equations, or false otherwise.
 */


public class SatisfiabilityEqualityEquations_990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                uf.union(x, y);
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                if (uf.find(x) == uf.find(y)) {
                    return false;
                }
            }
        }

        return true;
    }
}
