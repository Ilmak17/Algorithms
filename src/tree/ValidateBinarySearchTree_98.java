package tree;

/*
 * LeetCode Problem 98: Validate Binary Search Tree
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 */

public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val >= min && root.val <= max) {
            return false;
        }

        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

}
