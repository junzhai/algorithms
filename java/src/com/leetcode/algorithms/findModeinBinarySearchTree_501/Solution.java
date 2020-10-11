package com.leetcode.algorithms.findModeinBinarySearchTree_501;

import com.leetcode.algorithms.common.TreeNode;
import org.junit.Assert;

abstract public class Solution {
    abstract public int[] findMode(TreeNode root);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new InOrder(),
                new InOrder2Pass(),
                new MorrisTraversal()
        };

        int[] ret;

        for (Solution s : solutions) {
            ret = s.findMode(TreeNode.buildBinaryTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 2, 6}));
            Assert.assertArrayEquals(new int[]{2, 6}, ret);

            ret = s.findMode(TreeNode.buildBinaryTree(new Integer[]{}));
            Assert.assertArrayEquals(new int[]{}, ret);

            ret = s.findMode(TreeNode.buildBinaryTree(new Integer[]{2147483647}));
            Assert.assertArrayEquals(new int[]{2147483647}, ret);

            ret = s.findMode(TreeNode.buildBinaryTree(new Integer[]{1, null, 2, 2}));
            Assert.assertArrayEquals(new int[]{2}, ret);

            ret = s.findMode(TreeNode.buildBinaryTree(new Integer[]{1, 1, 2}));
            Assert.assertArrayEquals(new int[]{1}, ret);
        }
    }
}
