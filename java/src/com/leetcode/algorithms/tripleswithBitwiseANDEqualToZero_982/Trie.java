package com.leetcode.algorithms.tripleswithBitwiseANDEqualToZero_982;

@com.leetcode.algorithms.pattern.Trie
public class Trie extends Solution {
    private static class TrieNode {
        int count = 0;
        TrieNode left, right;
    }

    @Override
    public int countTriplets(int[] A) {
        TrieNode root = new TrieNode();
        int ret = 0, len = A.length;
        for (int i = 0, s2 = 0; i < len; i++) {
            if (A[i] == 0) {
                ret += 1;
                ret += 3 * (i + 1) * i;
                s2 += i;
                continue;
            }
            ret += 6 * count(root, A[i], 0);
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

    private int count(TrieNode root, int n, int index) {
        if (root == null) {
            return 0;
        }

        if (index >= 16) {
            return root.count;
        }

        int nn = n >>> 1, ret = count(root.left, nn, index + 1);
        if ((n & 1) == 0) {
            ret += count(root.right, nn, index + 1);
        }
        return ret;
    }

    private void add(TrieNode root, int n) {
        TrieNode p = root;
        for (int i = 0; i < 16; i++, n >>>= 1) {
            if ((n & 1) == 0) {
                if (p.left == null) {
                    p.left = new TrieNode();
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new TrieNode();
                }
                p = p.right;
            }
        }
        p.count += 1;
    }
}
