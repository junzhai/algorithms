package com.leetcode.algorithms.maximumProductofWordLengths_318;

public class Trie_16 extends Solution {
    private static class TrieNode {
        int val = 0;
        TrieNode[] children = new TrieNode[16];
    }

    @Override
    public int maxProduct(String[] words) {
        int ret = 0;
        TrieNode root = new TrieNode();
        for (String w : words) {
            ret = Math.max(ret, w.length() * getMaxLen(root, w, 0));
            add(root, w);
        }
        return ret;
    }

    private int cal(String w, int i) {
        int ret = 0;
        for (int c = 'a' + i; c <= 'z' && c < 'a' + i + 4; c++) {
            ret <<= 1;
            ret += w.indexOf(c) >= 0 ? 1 : 0;
        }
        return ret;
    }

    private void add(TrieNode root, String w) {
        TrieNode p = root;
        for (int i = 0; i < 26; i += 4) {
            int index = cal(w, i);
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.val = Math.max(p.val, w.length());
    }

    private int getMaxLen(TrieNode p, String w, int i) {
        if (i >= 26) {
            return p.val;
        }
        int index = cal(w, i), ret = 0;
        for (int j = 0; j < 16; j++) {
            if ((j & index) == 0 && p.children[j] != null) {
                ret = Math.max(ret, getMaxLen(p.children[j], w, i + 4));
            }
        }
        return ret;
    }
}
