package com.leetcode.algorithms.premium.closestLeafinaBinaryTree_742;

import com.leetcode.algorithms.common.TreeNode;
import com.leetcode.algorithms.pattern.DPInTree;
import org.junit.Assert;

@DPInTree
public class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        int[] ret = helper(root, k);
        return ret[3];
    }

    private int[] helper(TreeNode node, int k) {
        int[] ret = new int[4];
        if (node.left == null && node.right == null) {
            if (node.val == k) {
                ret[0] = 1;
                ret[1] = 0;
                ret[2] = 0;
                ret[3] = node.val;
            } else {
                ret[0] = 0;
                ret[1] = 0;
                ret[2] = node.val;
            }
            return ret;
        }

        if (node.left == null) {
            int[] r = helper(node.right, k);
            if (node.val == k) {
                ret[0] = 1;
                ret[1] = 0;
                ret[2] = r[1] + 1;
                ret[3] = r[2];
            } else if (r[0] == 1) {
                ret[0] = 1;
                ret[1] = r[1] + 1;
                ret[2] = r[2];
                ret[3] = r[3];
            } else {
                ret[0] = 0;
                ret[1] = r[1] + 1;
                ret[2] = r[2];
            }
            return ret;
        }

        if (node.right == null) {
            int[] l = helper(node.left, k);
            if (node.val == k) {
                ret[0] = 1;
                ret[1] = 0;
                ret[2] = l[1] + 1;
                ret[3] = l[2];
            } else if (l[0] == 1) {
                ret[0] = 1;
                ret[1] = l[1] + 1;
                ret[2] = l[2];
                ret[3] = l[3];
            } else {
                ret[0] = 0;
                ret[1] = l[1] + 1;
                ret[2] = l[2];
            }
            return ret;
        }

        int[] l = helper(node.left, k), r = helper(node.right, k);
        if (node.val == k) {
            ret[0] = 1;
            ret[1] = 0;
            ret[2] = Math.min(l[1], r[1]) + 1;
            ret[3] = l[1] <= r[1] ? l[2] : r[2];
        } else if (l[0] == 1) {
            ret[0] = 1;
            ret[1] = l[1] + 1;
            ret[2] = Math.min(l[2], ret[1] + r[1] + 1);
            ret[3] = l[2] <= ret[1] + r[1] + 1 ? l[3] : r[2];
        } else if (r[0] == 1) {
            ret[0] = 1;
            ret[1] = r[1] + 1;
            ret[2] = Math.min(r[2], ret[1] + l[1] + 1);
            ret[3] = r[2] <= ret[1] + l[1] + 1 ? r[3] : l[2];
        } else {
            ret[0] = 0;
            ret[1] = Math.min(l[1], r[1]) + 1;
            ret[2] = l[1] <= r[1] ? l[2] : r[2];
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.findClosestLeaf(TreeNode.buildBinaryTree(new Integer[]{1, 2, 3, 4, null, null, null, 5, null, 6}), 2);
        Assert.assertEquals(3, ret);

        ret = s.findClosestLeaf(TreeNode.buildBinaryTree(new Integer[]{1}), 1);
        Assert.assertEquals(1, ret);

        ret = s.findClosestLeaf(TreeNode.buildBinaryTree(new Integer[]{1, 3, 2}), 1);
        Assert.assertEquals(3, ret);
    }
}
