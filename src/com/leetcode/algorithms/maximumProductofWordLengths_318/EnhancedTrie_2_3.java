package com.leetcode.algorithms.maximumProductofWordLengths_318;

import java.util.Arrays;
import java.util.Comparator;

public class EnhancedTrie_2_3 extends Solution {
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

        int ret = 0, len = words.length;
        TrieNode root = new TrieNode();

        for (int i = 0; i < len; i++) {
            String w = words[i];
            int m = getMaxLen(root, w, 'a');
            if (m > 0) {
                ret = Math.max(ret, w.length() * m);
            }
            add(root, w);
        }
        return ret;
    }

    private void add(TrieNode root, String w) {
        TrieNode p = root;
        for (int c = 'a'; c <= 'z'; c++) {
            int index = w.indexOf(c) == -1 ? 0 : 1;
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.val = Math.max(p.val, w.length());
    }

    private int getMaxLen(TrieNode p, String w, int c) {
        if (p == null) {
            return 0;
        }

        if (c > 'z') {
            return p.val;
        }

        int ret = getMaxLen(p.children[0], w, c + 1);

        if (w.indexOf(c) == -1) {
            ret = Math.max(ret, getMaxLen(p.children[1], w, c + 1));
        }
        return ret;
    }
}
