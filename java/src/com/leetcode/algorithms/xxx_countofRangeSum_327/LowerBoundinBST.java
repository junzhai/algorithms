package com.leetcode.algorithms.xxx_countofRangeSum_327;

import com.leetcode.algorithms.pattern.BinarySearchTree;

@BinarySearchTree
public class LowerBoundinBST extends Solution {
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
        long sum = 0;
        for (int n : nums) {
            sum += n;
        }

        BSTNode root = new BSTNode(lower - sum);
        long lb = lower - sum, v = -sum;
        for (int i = len - 1; i >= 0; i--) {
            v += nums[i];
            ret += search(root, v, true) - search(root, v - diff, false);
            lb += nums[i];
            insert(root, lb);
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
