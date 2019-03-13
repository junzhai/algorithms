package com.leetcode.algorithms.tripleswithBitwiseANDEqualToZero_982;

import com.pattern.Trie;

@Trie
public class SuffixTree extends Solution {
    private static class SuffixTreeNode {
        int count = 0, val = 0;
        SuffixTreeNode left, right;

        SuffixTreeNode(int val) {
            this.val = val;
        }
    }

    @Override
    public int countTriplets(int[] A) {
        SuffixTreeNode root = new SuffixTreeNode(0);
        int ret = 0, len = A.length;
        for (int i = 0, s2 = 0; i < len; i++) {
            if (A[i] == 0) {
                ret += 1;
                ret += 3 * (i + 1) * i;
                s2 += i;
                continue;
            }
            ret += 6 * count(root, A[i]);
            ret += 6 * s2;
            for (int j = 0; j < i; j++) {
                int a = A[j] & A[i];
                if (a == 0) {
                    ret += 6;
                    s2 += 1;
                } else {
                    add(root, a);
                }
            }
        }
        return ret;
    }

    private int count(SuffixTreeNode root, int n) {
        if (root == null) {
            return 0;
        }

        if (root.count > 0) {
            return (root.val & n) == 0 ? root.count : 0;
        }

        int nn = n >>> 1, ret = count(root.left, nn);
        if ((n & 1) == 0) {
            ret += count(root.right, nn);
        }
        return ret;
    }

    private void add(SuffixTreeNode root, int n) {
        SuffixTreeNode p = root;
        for (int i = 0; i < 16; i++, n >>>= 1) {
            if (p.count == 0) {
                if ((n & 1) == 0) {
                    if (p.left == null) {
                        p.left = new SuffixTreeNode(n >>> 1);
                        p = p.left;
                        break;
                    }
                    p = p.left;
                } else {
                    if (p.right == null) {
                        p.right = new SuffixTreeNode(n >>> 1);
                        p = p.right;
                        break;
                    }
                    p = p.right;
                }
                continue;
            }
            if (p.val == n) {
                break;
            }

            if ((p.val & 1) == 0) {
                p.left = new SuffixTreeNode(p.val >>> 1);
                p.left.count = p.count;
                p.val = 0;
                p.count = 0;
                if ((n & 1) == 0) {
                    p = p.left;
                } else {
                    p.right = new SuffixTreeNode(n >>> 1);
                    p = p.right;
                    break;
                }
            } else {
                p.right = new SuffixTreeNode(p.val >>> 1);
                p.right.count = p.count;
                p.val = 0;
                p.count = 0;
                if ((n & 1) == 0) {
                    p.left = new SuffixTreeNode(n >>> 1);
                    p = p.left;
                    break;
                } else {
                    p = p.right;
                }
            }
        }
        p.count += 1;
    }
}
