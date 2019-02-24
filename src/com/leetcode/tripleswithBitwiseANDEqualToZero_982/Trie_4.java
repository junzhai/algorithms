package com.leetcode.tripleswithBitwiseANDEqualToZero_982;

import com.pattern.Trie;

@Trie
public class Trie_4 extends Solution {
    private static class TrieNode {
        int count = 0;
        TrieNode[] children = new TrieNode[4];
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

        int child = n & 3, nn = n >>> 2, ret = count(root.children[0], nn);
        if (child == 1) {
            ret += count(root.children[2], nn);
        } else if (child == 2) {
            ret += count(root.children[1], nn);
        } else if (child == 0) {
            ret += count(root.children[1], nn);
            ret += count(root.children[2], nn);
            ret += count(root.children[3], nn);
        }
        return ret;
    }

    private void add(TrieNode root, int n) {
        TrieNode p = root;
        for (int i = 0; i < 8; i++, n >>>= 2) {
            int child = n & 3;
            if (p.children[child] == null) {
                p.children[child] = new TrieNode();
            }
            p = p.children[child];
        }
        p.count += 1;
    }
}
