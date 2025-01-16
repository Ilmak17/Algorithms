package tree;

/*
 * LeetCode Problem 515: Find Largest Value in Each Tree Row
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                maxVal = Math.max(node.val, maxVal);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(maxVal);
        }

        return res;
    }
}
