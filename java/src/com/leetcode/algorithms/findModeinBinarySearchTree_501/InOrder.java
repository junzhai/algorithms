package com.leetcode.algorithms.findModeinBinarySearchTree_501;

import com.leetcode.algorithms.common.TreeNode;

import java.util.Arrays;

public class InOrder extends Solution {
    @Override
    public int[] findMode(TreeNode root) {
        int[] ret = helper(root, new int[]{0, 0});
        int len = ret.length;
        if (ret[len - 1] < ret[len - 2]) {
            return Arrays.copyOf(ret, len - 3);
        }
        return Arrays.copyOf(ret, len - 2);
    }

    private int[] helper(TreeNode p, int[] ret) {
        if (p == null) {
            return ret;
        }

        ret = helper(p.left, ret);

        int len = ret.length;
        if (len == 2) {
            ret = new int[]{p.val, 1, 1};
        } else if (len == 3) {
            if (ret[0] == p.val) {
                ret[1] += 1;
                ret[2] += 1;
            } else {
                ret = new int[]{ret[0], p.val, ret[1], 1};
            }
        } else {
            if (ret[len - 3] == p.val) {
                ret[len - 1] += 1;
                if (ret[len - 1] > ret[len - 2]) {
                    ret = new int[]{p.val, ret[len - 1], ret[len - 1]};
                }
            } else {
                if (ret[len - 1] == ret[len - 2]) {
                    ret = Arrays.copyOf(ret, len + 1);
                    ret[len - 2] = p.val;
                    ret[len] = 1;
                } else {
                    ret[len - 3] = p.val;
                    ret[len - 1] = 1;
                }
            }
        }
        return helper(p.right, ret);
    }
}
