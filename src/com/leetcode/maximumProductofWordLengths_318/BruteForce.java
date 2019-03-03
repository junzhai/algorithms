package com.leetcode.maximumProductofWordLengths_318;

/**
 * Don't be fooled. Bruteforce beats all other solutions.
 */
public class BruteForce extends Solution {
    @Override
    public int maxProduct(String[] words) {
        int[] m = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int c = 'a'; c <= 'z'; c++) {
                m[i] <<= 1;
                m[i] += words[i].indexOf(c) >= 0 ? 1 : 0;
            }
        }

        int ret = 0, len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((m[j] & m[i]) == 0) {
                    ret = Math.max(ret, words[j].length() * words[i].length());
                }
            }
        }

        return ret;
    }
}
