package com.leetcode.maximumProductofWordLengths_318;

import java.util.Arrays;
import java.util.Comparator;

public class EnhancedTrie_2_2 extends Solution {
    private static class TrieNode {
        int val = 0;
        TrieNode[] children = new TrieNode[2];
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

    private void add(TrieNode root, String w) {
        TrieNode p = root;
        int l = w.length();
        for (int c = 'a'; c <= 'z'; c++) {
            p.val = Math.max(p.val, l);
            int index = w.indexOf(c) == -1 ? 0 : 1;
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

        int ret = getMaxLen(p.children[0], w, c + 1, bound);

        if (w.indexOf(c) == -1) {
            ret = Math.max(ret, getMaxLen(p.children[1], w, c + 1, bound));
        }
        return ret;
    }
}
