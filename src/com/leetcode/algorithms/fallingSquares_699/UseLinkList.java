package com.leetcode.algorithms.fallingSquares_699;

import java.util.ArrayList;
import java.util.List;

public class UseLinkList extends Solution {
    private static class Node {
        int h;
        int index;
        Node next;

        Node(int index, int h) {
            this.index = index;
            this.h = h;
        }
    }

    @Override
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ret = new ArrayList<>();

        Node root = new Node(0, 0), lp = root;
        int max = 0;
        for (int[] pos : positions) {
            int left = pos[0], right = pos[0] + pos[1];
            lp = lp.index > left ? root : lp;
            while (lp.next != null && lp.next.index <= left) {
                lp = lp.next;
            }

            Node rp = lp;
            int h = rp.h;
            while (rp.next != null && rp.next.index < right) {
                rp = rp.next;
                h = Math.max(h, rp.h);
            }

            h += pos[1];

            if (lp == rp) {
                if (lp.index == left && rp.next != null && rp.next.index == right) {
                    lp.h = h;
                } else if (lp.index == left && rp.next == null) {
                    lp.next = new Node(right, lp.h);
                    lp.h = h;
                } else if (rp.next != null && rp.next.index == right) {
                    Node n = new Node(left, h);
                    n.next = lp.next;
                    lp.next = n;
                } else {
                    Node n = new Node(right, lp.h);
                    n.next = lp.next;
                    lp.next = new Node(left, h);
                    lp.next.next = n;
                }
            } else {
                if (lp.index == left && rp.next != null && rp.next.index == right) {
                    lp.h = h;
                    lp.next = rp.next;
                    rp.next = null;
                } else if (lp.index == left && rp.next == null) {
                    lp.h = h;
                    lp.next = rp;
                    rp.index = right;
                } else if (rp.next != null && rp.next.index == right) {
                    lp.next = rp;
                    rp.index = left;
                    rp.h = h;
                } else {
                    lp.next = new Node(left, h);
                    lp.next.next = rp;
                    rp.index = right;
                }
            }
            max = Math.max(max, h);
            ret.add(max);
        }
        return ret;
    }
}
