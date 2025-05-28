package tree;

/*
 * LeetCode Problem 337: House Robber III
 * Difficulty: Medium
 *
 * Problem Statement:
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 * Besides the root, each house has one and only one parent house.
 *  After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically
 *  contact the police if two directly-linked houses were broken into on the same night.
 * Given the root of the binary tree, return the maximum amount of money the
 * thief can rob without alerting the police.

 */

public class HouseRobberIII_337 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[2];

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = node.val + left[0] + right[0];

        return res;
    }
}
