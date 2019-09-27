package com.leetcode.algorithms.maximumGap_164;

import com.leetcode.algorithms.pattern.Trie;

@Trie
public class UseTrie extends Solution {
    private static class Node {
        Node left, right;
        int val, mask;

        Node(int val, int mask) {
            this.val = val;
            this.mask = mask;
        }

        Node(Node n) {
            this.left = n.left;
            this.right = n.right;
            this.val = n.val;
            this.mask = n.mask;
        }
    }

    @Override
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        Node root = new Node(nums[0], 0x7fffffff);
        for (int i = 1; i < len; i++) {
            int m = 0x7fffffff, v = nums[i];
            Node p = root;
            while (m > 0) {
                int pv = p.mask & p.val, vv = v & p.mask;
                if (pv == vv) {
                    m -= p.mask;
                    if (m > 0) {
                        if ((v & m + 1 >>> 1) == 0) {
                            p = p.left;
                        } else {
                            p = p.right;
                        }
                    }
                } else if (pv < vv) {
                    int mm = m + 1 >>> 1, mmm = 0;
                    pv ^= vv;
                    while ((pv & mm) == 0) {
                        mmm += mm;
                        mm >>>= 1;
                    }
                    p.left = new Node(p);
                    p.left.mask -= mmm;
                    p.right = new Node(v, m - mmm);
                    p.mask = mmm;
                    m = 0;
                } else {
                    int mm = m + 1 >>> 1, mmm = 0;
                    pv ^= vv;
                    while ((pv & mm) == 0) {
                        mmm += mm;
                        mm >>>= 1;
                    }
                    p.right = new Node(p);
                    p.right.mask -= mmm;
                    p.left = new Node(v, m - mmm);
                    p.mask = mmm;
                    m = 0;
                }
            }
        }

        return dfs(root)[2];
    }

    private int[] dfs(Node p) {
        if (p.left == null) {
            return new int[]{p.val, p.val, 0};
        }

        int[] l = dfs(p.left), r = dfs(p.right);
        int[] ret = new int[3];
        ret[0] = l[0];
        ret[1] = r[1];
        ret[2] = Math.max(l[2], r[0] - l[1]);
        ret[2] = Math.max(ret[2], r[2]);
        return ret;
    }
}
