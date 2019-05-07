package com.leetcode.algorithms.convertSortedListtoBinarySearchTree_109;

import com.leetcode.algorithms.common.ListNode;
import com.leetcode.algorithms.common.TreeNode;

public class MidPoint extends Solution {
    @Override
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count += 1;
            p = p.next;
        }

        return buildBST(head, count);
    }

    private TreeNode buildBST(ListNode p, int count) {
        if (count <= 0) {
            return null;
        }

        int step = count / 2;
        ListNode mid = p;
        for (int i = 0; i < step; i++) {
            mid = mid.next;
        }
        TreeNode ret = new TreeNode(mid.val);
        ret.left = buildBST(p, step);
        ret.right = buildBST(mid.next, count - step - 1);
        return ret;
    }
}
