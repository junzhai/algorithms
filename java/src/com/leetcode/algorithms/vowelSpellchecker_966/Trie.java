package com.leetcode.algorithms.vowelSpellchecker_966;

import java.util.HashSet;
import java.util.Set;

@com.pattern.algorithms.Trie
public class Trie extends Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[27];
        Set<String> vals = new HashSet<>();
        String val = null;
    }

    @Override
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        TrieNode root = new TrieNode();

        for (int i = wordlist.length - 1; i >= 0; i--) {
            String w = wordlist[i];

            TrieNode p1 = root, p2 = root;
            for (int j = 0; j < w.length(); j++) {
                char ch = Character.toLowerCase(w.charAt(j));
                int index1 = ch - 'a';
                if (p1.children[index1] == null) {
                    p1.children[index1] = new TrieNode();
                }
                p1 = p1.children[index1];

                int index2 = vowel.contains(ch) ? 26 : index1;
                if (p2.children[index2] == null) {
                    p2.children[index2] = new TrieNode();
                }
                p2 = p2.children[index2];
            }

            p1.vals.add(w);
            p1.val = w;

            if (p1 != p2) {
                p2.val = w;
            }
        }

        String[] ret = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            TrieNode p1 = root, p2 = root;
            for (int j = 0; j < q.length(); j++) {
                char ch = Character.toLowerCase(q.charAt(j));
                int index = ch - 'a';
                if (p1 != null) {
                    p1 = p1.children[index];
                }

                if (p2 != null) {
                    p2 = p2.children[vowel.contains(ch) ? 26 : index];
                }
            }

            if (p1 != null && !p1.vals.isEmpty()) {
                ret[i] = p1.vals.contains(q) ? q : p1.val;
            } else if (p2 != null) {
                ret[i] = p2.val;
            } else {
                ret[i] = "";
            }
        }
        return ret;
    }
}
