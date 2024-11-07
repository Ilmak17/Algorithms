package tree;

/*
 * LeetCode Problem 226: Invert Binary Tree
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the root of a binary tree, invert the tree, and return its root.
 */

public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        dfs(root.left);
        dfs(root.right);
    }
}
