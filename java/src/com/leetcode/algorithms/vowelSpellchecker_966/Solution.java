package com.leetcode.algorithms.vowelSpellchecker_966;

abstract public class Solution {
    abstract public String[] spellchecker(String[] wordlist, String[] queries);

    public static void main(String[] args) {
        Solution s = new Trie();
        String[] ret;
        ret = s.spellchecker(new String[]{"KiTe", "kite", "hare", "Hare"},
                new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"});
    }
}
