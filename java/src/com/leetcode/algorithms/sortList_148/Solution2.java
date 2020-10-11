package com.leetcode.algorithms.sortList_148;

import com.leetcode.algorithms.common.ListNode;

public class Solution2 extends Solution {
    @Override
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        int count = 1;
        a:
        while (true) {
            ListNode s = head, pres = null;
            while (s != null) {
                ListNode f = s, pref = null;
                for (int i = 0; i < count; i++) {
                    pref = f;
                    f = f.next;
                    if (f == null) {
                        if (s == head) {
                            break a;
                        }
                        break;
                    }
                }

                ListNode ns = null, nPres = null;
                if (f != null) {
                    ns = f;
                    nPres = null;
                    for (int i = 0; i < count; i++) {
                        nPres = ns;
                        ns = ns.next;
                        if (ns == null) {
                            break;
                        }
                    }
                }

                while (f != null && s != f && f != ns) {
                    if (s.val <= f.val) {
                        pres = s;
                        s = s.next;
                    } else {
                        pref.next = f.next;
                        if (f == nPres) {
                            nPres = pref;
                        }
                        f.next = s;
                        if (pres != null) {
                            pres.next = f;
                        } else {
                            head = f;
                        }
                        pres = f;
                        f = pref.next;
                    }
                }

                s = ns;
                pres = nPres;
            }
            count <<= 1;
        }

        return head;
    }
}
