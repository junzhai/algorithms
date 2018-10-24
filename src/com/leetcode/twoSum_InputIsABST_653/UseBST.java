package com.leetcode.twoSum_InputIsABST_653;


import com.leetcode.common.TreeNode;

public class UseBST extends Solution {
    @Override
    public boolean findTarget(TreeNode root, int k) {
        return find(root, root, k);
    }

    private boolean find(TreeNode node, TreeNode root, int k) {
        if (node == null) {
            return false;
        }

        boolean ret = (node.val << 1) != k && search(root, k - node.val);
        if (!ret) {
            ret = find(node.left, root, k);
        }
        if (!ret) {
            ret = find(node.right, root, k);
        }
        return ret;
    }

    private boolean search(TreeNode root, int k) {
        while (root != null) {
            if (root.val == k) {
                return true;
            }
            if (root.val < k) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return false;
    }

}
