package com.leetcode.algorithms.palindromePairs_336;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trie extends Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1;
    }

    @Override
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode forward = new TrieNode(), backward = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            TrieNode p = forward;
            for (int j = 0; j < w.length(); j++) {
                int k = w.charAt(j) - 'a';
                if (p.children[k] == null) {
                    p.children[k] = new TrieNode();
                }
                p = p.children[k];
            }
            p.index = i;
            p = backward;
            for (int j = w.length() - 1; j >= 0; j--) {
                int k = w.charAt(j) - 'a';
                if (p.children[k] == null) {
                    p.children[k] = new TrieNode();
                }
                p = p.children[k];
            }
            p.index = i;
        }

        Set<List<Integer>> ret = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            TrieNode p = backward;
            for (int j = -1; j < w.length(); j++) {
                if (j > -1) {
                    int k = w.charAt(j) - 'a';
                    if (p.children[k] == null) {
                        break;
                    }
                    p = p.children[k];
                }
                if (p.index >= 0 && p.index != i && isPalindrome(w, j + 1, w.length() - 1)) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(p.index);
                    ret.add(pair);
                }
            }

            p = forward;
            for (int j = w.length(); j >= 0; j--) {
                if (j < w.length()) {
                    int k = w.charAt(j) - 'a';
                    if (p.children[k] == null) {
                        break;
                    }
                    p = p.children[k];
                }
                if (p.index >= 0 && p.index != i && isPalindrome(w, 0, j - 1)) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(p.index);
                    pair.add(i);
                    ret.add(pair);
                }
            }
        }

        List<List<Integer>> a = new ArrayList<>();
        a.addAll(ret);
        return a;
    }

    private boolean isPalindrome(String w, int lo, int hi) {
        while (lo < hi) {
            if (w.charAt(lo) != w.charAt(hi)) {
                return false;
            }
            lo += 1;
            hi -= 1;
        }
        return true;
    }
}
