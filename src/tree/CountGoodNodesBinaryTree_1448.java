package tree;

/*
 * LeetCode Problem 1448: Count Good Nodes in Binary Tree
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a binary tree root, a node X in the tree is named good
 * if in the path from root to X there are no nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
 */

public class CountGoodNodesBinaryTree_1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) return 0;

        int counter = 0;
        if (root.val >= max) {
            counter = 1;
        }

        max = Math.max(root.val, max);
        counter += dfs(root.left, max);
        counter += dfs(root.right, max);

        return counter;
    }
}
