package com.leetcode.algorithms.premium.binaryTreeLongestConsecutiveSequenceII_549;

import com.leetcode.algorithms.common.TreeNode;
import com.leetcode.algorithms.pattern.DP;
import org.junit.Assert;

/**
 * Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
 * Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1] are both
 * considered valid, but the path [1,2,4,3] is not valid. On the other hand, the path can be in the
 * child-Parent-child order, where not necessarily be parent-child order.
 * <p>
 * Example 1:
 * Input:
 * 1
 * / \
 * 2   3
 * Output: 2
 * Explanation: The longest consecutive path is [1, 2] or [2, 1].
 * Example 2:
 * Input:
 * 2
 * / \
 * 1   3
 * Output: 3
 * Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
 * Note: All the values of tree nodes are in the range of [-1e7, 1e7].
 */
@DP
public class Solution {
    public int longestConsecutive(TreeNode root) {
        int[] ret = helper(root);
        return ret[0];
    }

    private int[] helper1(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0, 0};
        }

        int[] l = helper1(root.left), r = helper1(root.right);
        int v = root.val;
        int lv = root.left == null ? Integer.MIN_VALUE : root.left.val;
        int rv = root.right == null ? Integer.MIN_VALUE : root.right.val;

        int[] ret = new int[3];
        ret[0] = Math.max(l[0], r[0]);

        if (lv == rv) {
            if (v < lv) {
                ret[1] = Math.max(l[1], r[1]) + 1;
                ret[2] = 1;
                ret[0] = Math.max(ret[0], ret[1]);
            } else if (v == lv) {
                ret[1] = 1;
                ret[2] = 1;
                ret[0] = Math.max(ret[0], 1);
            } else {
                ret[1] = 1;
                ret[2] = Math.max(l[2], r[2]) + 1;
                ret[0] = Math.max(ret[0], ret[2]);
            }
        } else if (lv > rv) {
            if (v > lv) {
                ret[1] = 1;
                ret[2] = Math.max(l[2], r[2]) + 1;
                ret[0] = Math.max(ret[0], ret[2]);
            } else if (v == lv) {
                ret[1] = 1;
                ret[2] = r[2] + 1;
                ret[0] = Math.max(ret[0], ret[2]);
            } else if (v > rv) {
                ret[1] = l[1] + 1;
                ret[2] = r[2] + 1;
                ret[0] = Math.max(ret[0], l[1] + r[2] + 1);
            } else if (v == rv) {
                ret[1] = l[1] + 1;
                ret[2] = 1;
                ret[0] = Math.max(ret[0], ret[1]);
            } else {
                ret[1] = Math.max(l[1], r[1]) + 1;
                ret[2] = 1;
                ret[0] = Math.max(ret[0], ret[1]);
            }
        } else {
            if (v < lv) {
                ret[1] = Math.max(l[1], r[1]) + 1;
                ret[2] = 1;
                ret[0] = Math.max(ret[0], ret[1]);
            } else if (v == lv) {
                ret[1] = r[1] + 1;
                ret[2] = 1;
                ret[0] = Math.max(ret[0], ret[1]);
            } else if (v < rv) {
                ret[1] = r[1] + 1;
                ret[2] = l[2] + 1;
                ret[0] = Math.max(ret[0], l[2] + r[1] + 1);
            } else if (v == rv) {
                ret[1] = 1;
                ret[2] = l[2] + 1;
                ret[0] = Math.max(ret[0], ret[2]);
            } else {
                ret[1] = 1;
                ret[2] = Math.max(l[2], r[2]) + 1;
                ret[0] = Math.max(ret[0], ret[2]);
            }
        }

        return ret;
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0, 0};
        }

        int v = root.val;
        int lv = root.left == null ? Integer.MIN_VALUE : root.left.val;
        int[] l = helper(root.left);
        l[1] = v >= lv ? 1 : l[1] + 1;
        l[2] = v <= lv ? 1 : l[2] + 1;

        int rv = root.right == null ? Integer.MIN_VALUE : root.right.val;
        int[] r = helper(root.right);
        r[1] = v >= rv ? 1 : r[1] + 1;
        r[2] = v <= rv ? 1 : r[2] + 1;

        int[] ret = new int[3];

        ret[0] = Math.max(l[0], r[0]);
        ret[0] = Math.max(ret[0], l[1] + r[2] - 1);
        ret[0] = Math.max(ret[0], l[2] + r[1] - 1);

        ret[1] = Math.max(l[1], r[1]);
        ret[2] = Math.max(l[2], r[2]);

        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.longestConsecutive(TreeNode.buildBinaryTree(new Integer[]{
                7, 2, 11, 7, 9, 1, 5, null, null, 4, null, null, 8, null, 2, null, null, 3, 6
        }));
        Assert.assertEquals(3, ret);

        ret = s.longestConsecutive(TreeNode.buildBinaryTree(new Integer[]{3, 2, null}));
        Assert.assertEquals(2, ret);

        ret = s.longestConsecutive(TreeNode.buildBinaryTree(new Integer[]{3, null, 2}));
        Assert.assertEquals(2, ret);

        ret = s.longestConsecutive(TreeNode.buildBinaryTree(new Integer[]{1, 2, 3}));
        Assert.assertEquals(2, ret);

        ret = s.longestConsecutive(TreeNode.buildBinaryTree(new Integer[]{2, 2, 3}));
        Assert.assertEquals(2, ret);

        ret = s.longestConsecutive(TreeNode.buildBinaryTree(new Integer[]{2, 2, 2}));
        Assert.assertEquals(1, ret);

        ret = s.longestConsecutive(TreeNode.buildBinaryTree(new Integer[]{3}));
        Assert.assertEquals(1, ret);

        ret = s.longestConsecutive(TreeNode.buildBinaryTree(new Integer[]{2, 1, 3}));
        Assert.assertEquals(3, ret);

        ret = s.longestConsecutive(TreeNode.buildBinaryTree(new Integer[]{3, 1, 2}));
        Assert.assertEquals(2, ret);
    }
}
