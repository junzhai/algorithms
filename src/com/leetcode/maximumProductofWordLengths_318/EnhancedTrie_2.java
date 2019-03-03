package com.leetcode.maximumProductofWordLengths_318;

import java.util.Arrays;
import java.util.Comparator;

public class EnhancedTrie_2 extends Solution {
    private static class TrieNode {
        int val = 0;
        TrieNode[] children = new TrieNode[2];
    }

    @Override
    public int maxProduct(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        int ret = 0;
        TrieNode root = new TrieNode();
        boolean add = true;
        for (String w : words) {
            int l = w.length();
            if (l == 0) {
                break;
            }

            if (ret != 0 && ret / l >= root.val) {
                break;
            }

            int m = getMaxLen(root, w, 0, ret / l);
            if (m > 0) {
                ret = Math.max(ret, l * m);
                add = false;
            }

            if (add) {
                add(root, w);
            }
        }
        return ret;
    }

    private void add(TrieNode root, String w) {
        TrieNode p = root;
        int l = w.length();
        for (int i = 0; i < 26; i++) {
            p.val = Math.max(p.val, l);
            int index = w.indexOf('a' + i) == -1 ? 0 : 1;
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.val = Math.max(p.val, l);
    }

    private int getMaxLen(TrieNode p, String w, int i, int bound) {
        if (p == null) {
            return 0;
        }

        if (p.val <= bound) {
            return 0;
        }

        if (i >= 26) {
            return p.val;
        }

        int ret = getMaxLen(p.children[0], w, i + 1, bound);

        if (w.indexOf('a' + i) == -1) {
            ret = Math.max(ret, getMaxLen(p.children[1], w, i + 1, bound));
        }
        return ret;
    }
}
