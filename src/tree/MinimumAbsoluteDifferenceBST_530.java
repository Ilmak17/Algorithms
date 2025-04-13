package tree;

/*
 * LeetCode Problem 530: Minimum Absolute Difference in BST
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given the root of a Binary Search Tree (BST),
 * return the minimum absolute difference between the values of any two different nodes in the tree.
 */

public class MinimumAbsoluteDifferenceBST_530 {
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);

        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prev));
        }
        prev = node.val;

        inOrder(node.right);
    }
}
