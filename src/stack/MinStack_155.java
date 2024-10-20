package stack;

/*
 * LeetCode Problem 155: Min Stack
 * Difficulty: Medium
 *
 * Problem Statement:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */


class Pair {
    int val;
    int minVal;

    public Pair(int val, int minVal) {
        this.val = val;
        this.minVal = minVal;
    }
}

public class MinStack_155 {

    private Stack<Pair> stack;

    public MinStack_155() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair(val, val));
        } else {
            Pair prevPair = stack.peek();
            int minVal = Math.min(prevPair.minVal, val);
            stack.push(new Pair(val, minVal));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().minVal;
    }
}
