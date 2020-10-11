package com.leetcode.algorithms.findModeinBinarySearchTree_501;

import com.leetcode.algorithms.common.TreeNode;

public class InOrder2Pass extends Solution {
    private int maxFrequent = 0, maxCount = 0, curVal = 0, curFrequent = 0;

    @Override
    public int[] findMode(TreeNode root) {
        maxFrequent = 0;
        maxCount = 0;
        curVal = 0;
        curFrequent = 0;
        check(root);
        if (curFrequent > maxFrequent) {
            maxFrequent = curFrequent;
            maxCount = 1;
        } else if (curFrequent == maxFrequent && curFrequent != 0) {
            maxCount += 1;
        }

        int[] ret = new int[maxCount];
        maxCount = 0;
        curVal = 0;
        curFrequent = 0;
        helper(root, ret);
        if (curFrequent == maxFrequent && curFrequent != 0) {
            ret[maxCount] = curVal;
        }
        return ret;
    }

    private void helper(TreeNode p, int[] ret) {
        if (p == null) {
            return;
        }

        helper(p.left, ret);

        if (curFrequent == 0) {
            curVal = p.val;
            curFrequent = 1;
        } else if (curVal == p.val) {
            curFrequent += 1;
        } else if (curFrequent == maxFrequent) {
            ret[maxCount++] = curVal;
            curVal = p.val;
            curFrequent = 1;
        } else {
            curVal = p.val;
            curFrequent = 1;
        }

        helper(p.right, ret);
    }

    private void check(TreeNode p) {
        if (p == null) {
            return;
        }

        check(p.left);

        if (curFrequent == 0) {
            curVal = p.val;
            curFrequent = 1;
        } else if (curVal == p.val) {
            curFrequent += 1;
        } else {
            if (curFrequent > maxFrequent) {
                maxFrequent = curFrequent;
                maxCount = 1;
            } else if (curFrequent == maxFrequent) {
                maxCount += 1;
            }
            curVal = p.val;
            curFrequent = 1;
        }

        check(p.right);
    }
}
