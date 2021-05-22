package com.leetcode.algorithms.prefixandSuffixSearch_745;

import com.pattern.algorithms.Trie;

@Trie
class Trie_differentInsertion extends WordFilter {
    private static class TrieNode {
        int val;
        TrieNode[] children = new TrieNode[27];
    }

    private TrieNode root = new TrieNode();

    public Trie_differentInsertion(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int len = w.length();
            for (int j = len; j >= 0; j--) {
                TrieNode p = root;
                p.val = i;
                for (int k = j; k < len; k++) {
                    int index = w.charAt(k) - 'a';
                    if (p.children[index] == null) {
                        p.children[index] = new TrieNode();
                    }
                    p = p.children[index];
                    p.val = i;
                }

                if (p.children[26] == null) {
                    p.children[26] = new TrieNode();
                }
                p = p.children[26];
                p.val = i;

                for (int k = 0; k < len; k++) {
                    int index = w.charAt(k) - 'a';
                    if (p.children[index] == null) {
                        p.children[index] = new TrieNode();
                    }
                    p = p.children[index];
                    p.val = i;
                }
            }
        }
    }

    @Override
    public int f(String prefix, String suffix) {
        TrieNode p = root;
        for (int i = 0; i < suffix.length(); i++) {
            p = p.children[suffix.charAt(i) - 'a'];
            if (p == null) {
                return -1;
            }
        }

        p = p.children[26];

        for (int i = 0; i < prefix.length(); i++) {
            p = p.children[prefix.charAt(i) - 'a'];
            if (p == null) {
                return -1;
            }
        }

        return p.val;
    }
}