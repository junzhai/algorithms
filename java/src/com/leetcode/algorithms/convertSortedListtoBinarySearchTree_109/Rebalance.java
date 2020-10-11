package com.leetcode.algorithms.convertSortedListtoBinarySearchTree_109;

import com.leetcode.algorithms.common.ListNode;
import com.leetcode.algorithms.common.TreeNode;

public class Rebalance extends Solution {
    @Override
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode fakeRoot = new TreeNode(0);
        ListNode p = head;
        while (p != null) {
            insert(fakeRoot, p.val);
            rebalance(fakeRoot.right, fakeRoot);
            p = p.next;
        }
        return fakeRoot.right;
    }

    private int rebalance(TreeNode p, TreeNode parent) {
        if (p == null) {
            return 0;
        }

        int l = rebalance(p.left, p), r = rebalance(p.right, p);
        if (r - l > 1) {
            TreeNode rc = p.right;
            parent.right = rc;
            p.right = rc.left;
            rc.left = p;
            return r;
        }
        return Math.max(l, r) + 1;
    }

    private void insert(TreeNode root, int val) {
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = new TreeNode(val);
    }
}
