package com.leetcode.algorithms.implementQueueUsingStacks_232;

import java.util.Stack;

public class UsingStack_1 extends MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    @Override
    public void push(int x) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        s1.push(x);

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    @Override
    public int pop() {
        return s2.pop();
    }

    @Override
    public int peek() {
        return s2.peek();
    }

    @Override
    public boolean empty() {
        return s2.isEmpty();
    }
}
