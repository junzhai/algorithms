package com.leetcode.algorithms.implementQueueUsingStacks_232;

import java.util.Stack;

public class UsingStack_2 extends MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    @Override
    public void push(int x) {
        s1.push(x);
    }

    @Override
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    @Override
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    @Override
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
