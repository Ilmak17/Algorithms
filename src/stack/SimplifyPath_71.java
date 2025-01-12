package stack;

/*
 * LeetCode Problem 71: Simplify Path
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an absolute path for a Unix-style file system, which always begins with a slash '/'.
 * Your task is to transform this absolute path into its simplified canonical path.
 */


import java.util.Stack;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String el : path.split("/")) {
            if (el.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!el.isEmpty() && !el.equals(".")) {
                stack.push(el);
            }
        }

        StringBuilder builder = new StringBuilder();

        for (String s : stack) {
            builder.append("/").append(s);
        }

        return builder.isEmpty() ? "/" : builder.toString();
    }
}
