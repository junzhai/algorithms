package com.leetcode.maximumProductofWordLengths_318;

import java.util.Arrays;
import java.util.Comparator;

public class EnhancedTrie_16 extends Solution {
    private static class TrieNode {
        int val = 0;
        TrieNode[] children = new TrieNode[16];
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
        int l = w.length();
        for (int i = 0; i < 26; i += 4) {
            p.val = Math.max(p.val, l);
            int index = cal(w, i);
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.val = Math.max(p.val, l);
    }

    private int getMaxLen(TrieNode p, String w, int i, int bound) {
        if (p == null || p.val <= bound) {
            return 0;
        }

        if (i >= 26) {
            return p.val;
        }
        int index = cal(w, i), ret = 0;
        for (int j = 0; j < 16; j++) {
            if ((j & index) == 0) {
                ret = Math.max(ret, getMaxLen(p.children[j], w, i + 4, bound));
            }
        }
        return ret;
    }
}
