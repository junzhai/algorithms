package com.leetcode.algorithms.maximumProductofWordLengths_318;

public class Trie_2 extends Solution {
    private static class TrieNode {
        int val = 0;
        TrieNode[] children = new TrieNode[2];
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

    private void add(TrieNode root, String w) {
        TrieNode p = root;
        for (int i = 0; i < 26; i ++) {
            int index = w.indexOf('a' + i) == -1 ? 0 : 1;
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.val = Math.max(p.val, w.length());
    }

    private int getMaxLen(TrieNode p, String w, int i) {
        if (p == null) {
            return 0;
        }

        if (i >= 26) {
            return p.val;
        }
        int ret = 0;
        ret = Math.max(ret, getMaxLen(p.children[0], w, i + 1));

        if (w.indexOf('a' + i) == -1) {
            ret = Math.max(ret, getMaxLen(p.children[1], w, i + 1));
        }
        return ret;
    }
}
