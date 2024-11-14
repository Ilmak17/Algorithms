package tree;

/*
 * LeetCode Problem 230: Kth Smallest Element in a BST
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the root of a binary search tree, and an integer k,
 *  return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */

public class KthSmallestElementBST_230 {
    int counter = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return result;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.left, k);
        counter++;

        if (counter == k) {
            result = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
