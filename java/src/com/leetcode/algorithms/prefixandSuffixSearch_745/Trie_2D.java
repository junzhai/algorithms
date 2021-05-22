package com.leetcode.algorithms.prefixandSuffixSearch_745;

import com.pattern.algorithms.Trie;

@Trie
class Trie_2D extends WordFilter {
    private static class TrieNode {
        int val;
        TrieNode[] children = new TrieNode[26];
        STrieNode root = new STrieNode();
    }

    private static class STrieNode {
        int val;
        STrieNode[] children = new STrieNode[26];
    }

    private TrieNode root = new TrieNode();

    public Trie_2D(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int len = w.length();
            TrieNode p = root;
            for (int j = 0; j < len; j++) {
                p.val = i;
                p.root.val = i;
                STrieNode sp = p.root;
                for (int k = len - 1; k >= 0; k--) {
                    sp.val = i;
                    int sIndex = w.charAt(k) - 'a';
                    if (sp.children[sIndex] == null) {
                        sp.children[sIndex] = new STrieNode();
                    }
                    sp = sp.children[sIndex];
                }
                sp.val = i;

                int index = w.charAt(j) - 'a';
                if (p.children[index] == null) {
                    p.children[index] = new TrieNode();
                }
                p = p.children[index];
            }
            p.val = i;
            p.root.val = i;
            STrieNode sp = p.root;
            for (int k = len - 1; k >= 0; k--) {
                sp.val = i;
                int sIndex = w.charAt(k) - 'a';
                if (sp.children[sIndex] == null) {
                    sp.children[sIndex] = new STrieNode();
                }
                sp = sp.children[sIndex];
            }
            sp.val = i;
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

        STrieNode sp = p.root;
        for (int i = suffix.length() - 1; i >= 0; i--) {
            sp = sp.children[suffix.charAt(i) - 'a'];
            if (sp == null) {
                return -1;
            }
        }

        return sp.val;
    }
}