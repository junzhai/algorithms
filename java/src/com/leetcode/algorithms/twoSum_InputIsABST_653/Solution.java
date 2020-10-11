package com.leetcode.algorithms.twoSum_InputIsABST_653;

import com.leetcode.algorithms.common.TreeNode;
import org.junit.Assert;

import static com.leetcode.algorithms.common.TreeNode.buildBinaryTree;


abstract public class Solution {
    abstract public boolean findTarget(TreeNode root, int k);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new UseBST(),
                new UseHashSet(),
        };

        boolean ret;
        for (Solution s : solutions) {
            TreeNode root = buildBinaryTree(new Integer[]{1});
            ret = s.findTarget(root, 2);
            Assert.assertEquals(ret, false);

            root = buildBinaryTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
            ret = s.findTarget(root, 28);
            Assert.assertEquals(ret, false);
        }
    }
}