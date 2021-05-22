package com.leetcode.algorithms.xxx_countofRangeSum_327;

import com.pattern.algorithms.BinarySearchTree;

@BinarySearchTree
public class LowerBoundinBST2 extends Solution {
    private class BSTNode {
        long val;
        int count, smaller;
        BSTNode left, right;

        BSTNode(long val) {
            this.val = val;
            this.count = 1;
        }
    }

    @Override
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length, diff = upper - lower, ret = 0;
        long sum = 0, lb = lower;
        BSTNode root = new BSTNode(lower);

        for (int i = 0; i < len - 1; i++) {
            sum += nums[i];
            ret += search(root, sum, true) - search(root, sum - diff, false);
            lb += nums[i];
            insert(root, lb);
        }

        if (len > 0) {
            sum += nums[len - 1];
            ret += search(root, sum, true) - search(root, sum - diff, false);
        }
        return ret;
    }

    private void insert(BSTNode root, long v) {
        BSTNode p = root;
        while (p != null) {
            if (v == p.val) {
                p.count += 1;
                break;
            } else if (v < p.val) {
                p.smaller += 1;
                if (p.left == null) {
                    p.left = new BSTNode(v);
                    break;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new BSTNode(v);
                    break;
                }
                p = p.right;
            }
        }
    }

    private int search(BSTNode root, long v, boolean equal) {
        int ret = 0;
        BSTNode p = root;
        while (p != null) {
            if (p.val == v) {
                return ret + p.smaller + (equal ? p.count : 0);
            }
            if (p.val < v) {
                ret += p.count + p.smaller;
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return ret;
    }
}
