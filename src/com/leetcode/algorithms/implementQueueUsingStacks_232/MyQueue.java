package com.leetcode.algorithms.implementQueueUsingStacks_232;

abstract public class MyQueue {
    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
    }

    /**
     * Push element x to the back of queue.
     */
    abstract public void push(int x);

    /**
     * Removes the element from in front of queue and returns that element.
     */
    abstract public int pop();

    /**
     * Get the front element.
     */
    abstract public int peek();

    /**
     * Returns whether the queue is empty.
     */
    abstract public boolean empty();
}
