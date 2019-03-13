package com.leetcode.algorithms.tripleswithBitwiseANDEqualToZero_982;

import com.pattern.Trie;

@Trie
public class Trie_256 extends Solution {
    private static class TrieNode {
        int count = 0;
        TrieNode[] children = new TrieNode[256];
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

    private int count(TrieNode root, int n) {
        if (root == null) {
            return 0;
        }

        if (root.count > 0) {
            return root.count;
        }

        int v = n & 255, nn = n >>> 8, ret = 0;
        for (int i = 0; i < 256; i++) {
            if ((v & i) == 0) {
                ret += count(root.children[i], nn);
            }
        }
        return ret;
    }

    private void add(TrieNode root, int n) {
        TrieNode p = root;
        for (int i = 0; i < 2; i++, n >>>= 8) {
            int child = n & 255;
            if (p.children[child] == null) {
                p.children[child] = new TrieNode();
            }
            p = p.children[child];
        }
        p.count += 1;
    }
}
