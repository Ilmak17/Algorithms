package tree;

/*
 * LeetCode Problem 543: Diameter of Binary Tree
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between
 *  any two nodes in a tree. This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 */

public class DiameterBinaryTree_543 {
    int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        dfs(root);

        return maxDiameter;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCounter = dfs(root.left);
        int rightCounter = dfs(root.right);

        maxDiameter = Math.max(maxDiameter, leftCounter + rightCounter);

        return Math.max(leftCounter, rightCounter) + 1;
    }
}
