package tree;

/*
 * LeetCode Problem 222: Count Complete Tree Nodes
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
 * and all nodes in the last level are as far left as possible. It can have
 * between 1 and 2h nodes inclusive at the last level h.
 * Design an algorithm that runs in less than O(n) time complexity.
 */

public class CountCompleteTreeNodes_222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int h1 = getHeight(root, false);
        int h2 = getHeight(root, true);
        if (h1 == h2) return (1 << h1) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getHeight(TreeNode node, boolean isRight) {
        int h = 0;

        while (node != null) {
            h++;
            node = isRight ? node.right : node.left;
        }

        return h;
    }
}
