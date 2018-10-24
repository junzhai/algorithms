package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public static TreeNode buildBinaryTree(Integer[] val) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode ret = new TreeNode(val[0]);
        q.offer(ret);
        int i = 1;
        while (i < val.length) {
            TreeNode p = q.poll();
            if (val[i] != null) {
                p.left = new TreeNode(val[i]);
                q.offer(p.left);
            }
            i += 1;
            if (val[i] != null) {
                p.right = new TreeNode(val[i]);
                q.offer(p.right);
            }
            i += 1;
        }
        return ret;
    }

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

}
