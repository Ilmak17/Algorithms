package tree;

/*
 * LeetCode Problem 110: Balanced Binary Tree
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given a binary tree, determine if it is height-balanced.
 */

public class BalancedBinaryTree_110 {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }

        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
