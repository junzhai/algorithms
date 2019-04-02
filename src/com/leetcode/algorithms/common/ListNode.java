package com.leetcode.algorithms.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode build(int[] vals) {
        ListNode root = null, p = null;
        for (int v : vals) {
            if (root == null) {
                root = new ListNode(v);
                p = root;
            } else {
                p.next = new ListNode(v);
                p = p.next;
            }
        }
        return root;
    }
}