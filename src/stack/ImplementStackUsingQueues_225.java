package stack;

/*
 * LeetCode Problem 225: Implement Stack using Queues
 * Difficulty: Easy
 *
 * Problem Statement:
 * Implement a last-in-first-out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStackUsingQueues_225 {
    private final Deque<Integer> q;
    public ImplementStackUsingQueues_225() {
        this.q = new ArrayDeque<>();
    }

    public void push(int x) {
        this.q.addLast(x);
    }

    public int pop() {
        int size = this.q.size();
        for(int i = 0; i < size - 1; i++)
            this.push(this.q.pollFirst());
        return this.q.pollFirst();
    }

    public int top() {
        int size = q.size();
        for(int i = 0; i < size - 1; i++)
            this.push(this.q.pollFirst());

        int res = this.q.peekFirst();
        this.push(this.q.pollFirst());
        return res;
    }

    public boolean empty() {
        return this.q.size() == 0;
    }
}
