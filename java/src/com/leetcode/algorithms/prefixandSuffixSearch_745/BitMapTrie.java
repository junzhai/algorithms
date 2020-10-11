package com.leetcode.algorithms.prefixandSuffixSearch_745;

import com.leetcode.algorithms.pattern.Trie;

@Trie
class BitMapTrie extends WordFilter {
    private static class TrieNode {
        byte[] pBitmap, sBitmap;
        TrieNode[] children = new TrieNode[26];

        TrieNode(int max) {
            pBitmap = new byte[max];
            sBitmap = new byte[max];
        }
    }

    private final TrieNode root;
    private final int max;

    public BitMapTrie(String[] words) {
        max = (words.length + 7) / 8;
        root = new TrieNode(max);

        for (int i = 0; i < words.length; i++) {
            byte[] by = words[i].getBytes();
            int d = i >>> 3, m = 1 << i % 8;

            TrieNode p = root;
            for (int k = 0; k < by.length; k++) {
                p.pBitmap[d] |= m;
                int index = by[k] - 'a';
                if (p.children[index] == null) {
                    p.children[index] = new TrieNode(max);
                }
                p = p.children[index];
            }
            p.pBitmap[d] |= m;

            p = root;
            for (int k = by.length - 1; k >= 0; k--) {
                p.sBitmap[d] |= m;
                int index = by[k] - 'a';
                if (p.children[index] == null) {
                    p.children[index] = new TrieNode(max);
                }
                p = p.children[index];
            }
            p.sBitmap[d] |= m;
        }
    }

    @Override
    public int f(String prefix, String suffix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            p = p.children[prefix.charAt(i) - 'a'];
            if (p == null) {
                return -1;
            }
        }
        byte[] by1 = p.pBitmap;

        p = root;
        for (int i = suffix.length() - 1; i >= 0; i--) {
            p = p.children[suffix.charAt(i) - 'a'];
            if (p == null) {
                return -1;
            }
        }
        byte[] by2 = p.sBitmap;

        for (int i = max - 1; i >= 0; i--) {
            byte a = (byte) (by1[i] & by2[i]);
            if (a != 0) {
                int t = 7, m = 128;
                while ((a & m) == 0) {
                    t -= 1;
                    m >>>= 1;
                }
                return (i << 3) + t;
            }
        }
        return -1;
    }
}