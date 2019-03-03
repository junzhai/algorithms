package com.leetcode.maximumProductofWordLengths_318;

import java.util.Arrays;
import java.util.Comparator;

public class EnhancedTrie_16_2 extends Solution {
    private static class TrieNode {
        int val = 0;
        TrieNode[] children = new TrieNode[16];
    }

    @Override
    public int maxProduct(String[] words) {
        int ret = 0;
        TrieNode root = new TrieNode();
        for (String w : words) {
            int l = w.length();
            if (l == 0) {
                break;
            }

            ret = Math.max(ret, l * getMaxLen(root, w, 'a', ret / l));
            add(root, w);
        }
        return ret;
    }

    private int cal(String w, int ch) {
        int ret = 0;
        for (int c = ch; c <= 'z' && c < ch + 4; c++) {
            ret <<= 1;
            ret += w.indexOf(c) >= 0 ? 1 : 0;
        }
        return ret;
    }

    private void add(TrieNode root, String w) {
        TrieNode p = root;
        int l = w.length();
        for (int c = 'a'; c <= 'z'; c += 4) {
            p.val = Math.max(p.val, l);
            int index = cal(w, c);
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.val = Math.max(p.val, l);
    }

    private int getMaxLen(TrieNode p, String w, int c, int bound) {
        if (p == null || p.val <= bound) {
            return 0;
        }

        if (c > 'z') {
            return p.val;
        }
        int index = cal(w, c), ret = 0;
        for (int j = 0; j < 16; j++) {
            if ((j & index) == 0) {
                ret = Math.max(ret, getMaxLen(p.children[j], w, c + 4, bound));
            }
        }
        return ret;
    }
}
