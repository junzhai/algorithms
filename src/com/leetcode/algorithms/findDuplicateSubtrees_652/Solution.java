package com.leetcode.algorithms.findDuplicateSubtrees_652;

import com.leetcode.algorithms.common.TreeNode;

import java.util.List;

abstract public class Solution {
    abstract public List<TreeNode> findDuplicateSubtrees(TreeNode root);

    public static void main(String[] args) {
        Solution s = new ATrick();
        List<TreeNode> ret;

        ret = s.findDuplicateSubtrees(TreeNode.buildBinaryTree(new Integer[]{
                0, 0, 0, 0, null, null, 0, 0, 0, 0, 0}));

        ret = s.findDuplicateSubtrees(TreeNode.buildBinaryTree(new Integer[]{
                1, 2, 3, 4, null, 2, 4, null, null, 4}));
    }
}
