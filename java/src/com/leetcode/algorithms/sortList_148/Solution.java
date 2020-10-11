package com.leetcode.algorithms.sortList_148;

import com.leetcode.algorithms.common.ListNode;

abstract public class Solution {
    abstract public ListNode sortList(ListNode head);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new Solution1(),
                new Solution2()
        };

        ListNode ret;
        for (Solution s : solutions) {
            ret = s.sortList(ListNode.build(new int[]{}));
            ret = s.sortList(ListNode.build(new int[]{4, 3, 2, 1}));
            ret = s.sortList(ListNode.build(new int[]{-1, 5, 3, 4, 0}));
            ret = s.sortList(ListNode.build(new int[]{4, 2, 1, 3}));
        }
    }
}
