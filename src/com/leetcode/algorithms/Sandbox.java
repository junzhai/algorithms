package com.leetcode.algorithms;

import org.junit.Assert;

import java.util.Arrays;

public class Sandbox {
    private static class STNode {
        int low, high, capacity, used;
        STNode left, right;

        STNode(int low, int high, int capacity) {
            this.low = low;
            this.high = high;
            this.capacity = capacity;
        }
    }

    private final int capacity;
    private final int[][] stacks;
    private final int[] len;
    private final STNode root;
    private int total, pushIdx, popIdx;

    public Sandbox(int capacity) {
        this.capacity = capacity;

        int s = 200000 / capacity;
        stacks = new int[s][capacity];
        len = new int[s];

        root = buildST(0, s - 1);

        total = 0;
        pushIdx = 0;
        popIdx = -1;
    }

    public void push(int val) {
        stacks[pushIdx][len[pushIdx]] = val;
        len[pushIdx] += 1;
        updateST(root, pushIdx, 1);
        total += 1;

        if (pushIdx > popIdx) {
            popIdx = pushIdx;
        }

        if (len[pushIdx] == capacity) {
            pushIdx = nextPushIdx(root);
        }
    }

    public int pop() {
        if (total == 0) {
            return -1;
        }

        int ret = stacks[popIdx][len[popIdx] - 1];
        len[popIdx] -= 1;
        updateST(root, popIdx, -1);
        total -= 1;

        if (pushIdx > popIdx) {
            pushIdx = popIdx;
        }

        if (len[popIdx] == 0) {
            popIdx = nextPopIdx(root);
        }
        return ret;
    }

    public int popAtStack(int index) {
        if (len[index] == 0) {
            return -1;
        }

        int ret = stacks[index][len[index] - 1];
        len[index] -= 1;
        updateST(root, index, -1);
        total -= 1;

        if (index < pushIdx) {
            pushIdx = index;
        }
        if (len[popIdx] == 0) {
            popIdx = nextPopIdx(root);
        }
        return ret;
    }

    private STNode buildST(int low, int high) {
        STNode ret = new STNode(low, high, (high - low + 1) * capacity);
        if (low < high) {
            int m = (low + high) / 2;
            ret.left = buildST(low, m);
            ret.right = buildST(m + 1, high);
        }
        return ret;
    }

    private void updateST(STNode p, int index, int v) {
        p.used += v;

        if (p.low < p.high) {
            if (index <= p.left.high) {
                updateST(p.left, index, v);
            } else {
                updateST(p.right, index, v);
            }
        }
    }

    private int nextPushIdx(STNode p) {
        if (p.used == p.capacity) {
            return p.high + 1;
        }

        if (p.low == p.high) {
            return p.low;
        }

        if (p.left.used < p.left.capacity) {
            return nextPushIdx(p.left);
        } else {
            return nextPushIdx(p.right);
        }
    }

    private int nextPopIdx(STNode p) {
        if (p.used == 0) {
            return p.low - 1;
        }

        if (p.low == p.high) {
            return p.low;
        }

        if (p.right.used > 0) {
            return nextPopIdx(p.right);
        } else {
            return nextPopIdx(p.left);
        }
    }

    public static void main(String[] args) {
        Sandbox D = new Sandbox(2);  // Initialize with capacity = 2
        D.push(1);
        D.push(2);
        D.push(3);
        D.push(4);
        D.push(5);
        Assert.assertEquals(2, D.popAtStack(0));
        D.push(20);
        D.push(21);
        Assert.assertEquals(20, D.popAtStack(0));
        Assert.assertEquals(21, D.popAtStack(2));
        Assert.assertEquals(5, D.pop());
        Assert.assertEquals(4, D.pop());
        Assert.assertEquals(3, D.pop());
        Assert.assertEquals(1, D.pop());
        Assert.assertEquals(-1, D.pop());
    }
}