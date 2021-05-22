package com.leetcode.algorithms.xxx_countofRangeSum_327;

import com.pattern.algorithms.BinarySearchTree;

@BinarySearchTree
public class RollingSuminBST extends Solution {
    private class BSTNode {
        long val;
        int count;
        BSTNode left, right;

        BSTNode(long val) {
            this.val = val;
            count = 1;
        }
    }

    @Override
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length, ret = 0;
        BSTNode root = new BSTNode(0);
        long l = lower, u = upper, sum = 0;
        for (int i = 0; i < len; i++) {
            l -= nums[i];
            u -= nums[i];
            ret += search(root, l, u);
            sum -= nums[i];
            insert(root, sum);
        }
        return ret;
    }

    private void insert(BSTNode p, long v) {
        if (v == p.val) {
            p.count += 1;
            return;
        }
        if (v < p.val) {
            if (p.left == null) {
                p.left = new BSTNode(v);
                return;
            }
            insert(p.left, v);
        } else {
            if (p.right == null) {
                p.right = new BSTNode(v);
                return;
            }
            insert(p.right, v);
        }
    }

    private int search(BSTNode p, long l, long u) {
        if (p == null || l > u) {
            return 0;
        }

        if (p.val < l) {
            return search(p.right, l, u);
        }

        if (p.val > u) {
            return search(p.left, l, u);
        }

        return search(p.right, p.val + 1, u) + search(p.left, l, p.val - 1) + p.count;
    }
}
