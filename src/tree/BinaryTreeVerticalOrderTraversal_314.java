
package tree;

/*
 * LeetCode Problem 314. Binary Tree Vertical Order Traversal
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values.
 * (i.e., from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair {
    TreeNode node;
    int x;

    public Pair(TreeNode node, int x) {
        this.node = node;
        this.x = x;
    }
}

public class BinaryTreeVerticalOrderTraversal_314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode cur = pair.node;
            int line = pair.x;

            map.putIfAbsent(line, new ArrayList<>());
            map.get(line).add(cur.val);

            if (cur.left != null) {
                queue.add(new Pair(cur.left, line - 1));
            }

            if (cur.right != null) {
                queue.add(new Pair(cur.right, line + 1));
            }
        }

        List<List<Integer>> response = new ArrayList<>();
        for (List<Integer> col : map.values()) {
            response.add(col);
        }

        return response;
    }
}

