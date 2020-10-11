package com.leetcode.algorithms.maximumWidthofBinaryTree_662;

import com.leetcode.algorithms.common.TreeNode;
import org.junit.Assert;

public class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        int[][] rs = helper(root, 0, 0);
        int ret = 0;
        for (int[] r : rs) {
            ret = Math.max(ret, r[1] - r[0] + 1);
        }
        return ret;
    }

    private int[][] helper(TreeNode p, int n, int h) {
        int[][] ret;
        if (p.left == null && p.right == null) {
            ret = new int[h + 1][2];
        } else if (p.left == null) {
            ret = helper(p.right, (n << 1) + 1, h + 1);
        } else if (p.right == null) {
            ret = helper(p.left, n << 1, h + 1);
        } else {
            int[][] l = helper(p.left, n << 1, h + 1), r = helper(p.right, (n << 1) + 1, h + 1);
            if (l.length < r.length) {
                ret = r;
                for (int i = h + 1; i < l.length; i++) {
                    ret[i][0] = l[i][0];
                }
            } else {
                ret = l;
                for (int i = h + 1; i < r.length; i++) {
                    ret[i][1] = r[i][1];
                }
            }
        }

        ret[h] = new int[]{n, n};
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;
        ret = s.widthOfBinaryTree(TreeNode.buildBinaryTree(new Integer[]{1, 3, 2, 5, 3, null, 9}));
        Assert.assertEquals(4, ret);
    }
}
