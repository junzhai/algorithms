package com.leetcode.algorithms.longestValidParentheses_32;

public class ParenthesesLevel extends Solution {
    @Override
    public int longestValidParentheses(String s) {
        int[] lens = new int[s.length()];
        int level = -1, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                level += 1;
                continue;
            }
            if (level < 0) {
                lens[0] = 0;
                continue;
            }

            lens[level] += lens[level + 1] + 2;
            lens[level + 1] = 0;
            max = Math.max(max, lens[level]);
            level -= 1;
        }
        return max;
    }
}
