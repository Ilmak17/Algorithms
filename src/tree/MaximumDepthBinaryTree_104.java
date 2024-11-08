package tree;

/*
 * LeetCode Problem 104: Maximum Depth of Binary Tree
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along
 * the longest path from the root node down to the farthest leaf node.
 */

public class MaximumDepthBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int counterLeft = dfs(root.left);
        int counterRight = dfs(root.right);

        return Math.max(counterLeft, counterRight) + 1;
    }
}
