package com.leetcode.algorithms.sortList_148;

import com.leetcode.algorithms.common.ListNode;

public class Solution1 extends Solution {
    @Override
    public ListNode sortList(ListNode head) {
        boolean next = true;
        int len = 2;
        while (next) {
            next = false;
            int l = len >>> 1;
            ListNode p = head, nh = null, nt = null;
            while (p != null) {
                ListNode s = p, pf = null, f = null;
                for (int i = 0; i < len; i++) {
                    if (i == l - 1) {
                        pf = p;
                    }
                    if (i == l) {
                        f = p;
                    }
                    p = p.next;
                    if (p == null) {
                        break;
                    }
                }

                if (!next && p != null) {
                    next = true;
                }

                while (f != null && s != f && f != p) {
                    if (s.val <= f.val) {
                        if (nh == null) {
                            nh = s;
                            nt = s;
                        } else {
                            nt.next = s;
                            nt = s;
                        }
                        s = s.next;
                    } else {
                        if (nh == null) {
                            nh = f;
                            nt = f;
                        } else {
                            nt.next = f;
                            nt = f;
                        }
                        f = f.next;
                        pf.next = f;
                    }
                    nt.next = null;
                }
                if (s != f) {
                    if (nh == null) {
                        nh = s;
                    } else {
                        nt.next = s;
                    }
                    if (pf != null) {
                        nt = pf;
                        nt.next = null;
                    }
                }
                while (f != p && f != null) {
                    if (nh == null) {
                        nh = f;
                    } else {
                        nt.next = f;
                    }
                    nt = f;
                    f = f.next;
                    nt.next = null;
                }
            }
            head = nh;
            len <<= 1;
        }
        return head;
    }
}
