package com.leetcode.algorithms.findModeinBinarySearchTree_501;

import com.leetcode.algorithms.common.TreeNode;

@com.pattern.algorithms.MorrisTraversal
public class MorrisTraversal extends Solution {
    private int curVal = 0, curFrequent = 0, maxFrequent = 0, maxCount = 0;

    @Override
    public int[] findMode(TreeNode root) {
        maxFrequent = 0;
        maxCount = 0;
        curVal = 0;
        curFrequent = 0;
        check(root);
        int[] ret = new int[maxCount];
        maxCount = 0;
        curVal = 0;
        curFrequent = 0;
        helper(root, ret);
        return ret;
    }

    private void helper(TreeNode root, int[] ret) {
        TreeNode p = root;
        while (p != null) {
            if (p.left == null) {
                if (curFrequent == 0) {
                    curVal = p.val;
                    curFrequent = 1;
                } else if (curVal == p.val) {
                    curFrequent += 1;
                } else if (curFrequent == maxFrequent) {
                    ret[maxCount++] = curVal;
                    curFrequent = 1;
                    curVal = p.val;
                } else {
                    curVal = p.val;
                    curFrequent = 1;
                }
                p = p.right;
            } else {
                TreeNode pp = p.left;
                while (pp.right != null && pp.right != p) {
                    pp = pp.right;
                }
                if (pp.right == null) {
                    pp.right = p;
                    p = p.left;
                } else {
                    pp.right = null;
                    if (curVal == p.val) {
                        curFrequent += 1;
                    } else if (curFrequent == maxFrequent) {
                        ret[maxCount++] = curVal;
                        curFrequent = 1;
                        curVal = p.val;
                    } else {
                        curVal = p.val;
                        curFrequent = 1;
                    }
                    p = p.right;
                }
            }
        }
        if (curFrequent == maxFrequent && curFrequent != 0) {
            ret[maxCount] = curVal;
        }
    }

    private void check(TreeNode root) {
        TreeNode p = root;
        while (p != null) {
            if (p.left == null) {
                if (curFrequent == 0) {
                    curVal = p.val;
                    curFrequent = 1;
                } else if (curVal == p.val) {
                    curFrequent += 1;
                } else if (curFrequent > maxFrequent) {
                    maxFrequent = curFrequent;
                    maxCount = 1;
                    curVal = p.val;
                    curFrequent = 1;
                } else if (curFrequent == maxFrequent) {
                    maxCount += 1;
                    curVal = p.val;
                    curFrequent = 1;
                } else {
                    curVal = p.val;
                    curFrequent = 1;
                }
                p = p.right;
            } else {
                TreeNode pp = p.left;
                while (pp.right != null && pp.right != p) {
                    pp = pp.right;
                }

                if (pp.right == null) {
                    pp.right = p;
                    p = p.left;
                } else {
                    pp.right = null;
                    if (curVal == p.val) {
                        curFrequent += 1;
                    } else if (curFrequent > maxFrequent) {
                        maxFrequent = curFrequent;
                        maxCount = 1;
                        curVal = p.val;
                        curFrequent = 1;
                    } else if (curFrequent == maxFrequent) {
                        maxCount += 1;
                        curVal = p.val;
                        curFrequent = 1;
                    } else {
                        curVal = p.val;
                        curFrequent = 1;
                    }
                    p = p.right;
                }
            }
        }

        if (curFrequent > maxFrequent) {
            maxFrequent = curFrequent;
            maxCount = 1;
        } else if (curFrequent == maxFrequent && curFrequent != 0) {
            maxCount += 1;
        }
    }
}
