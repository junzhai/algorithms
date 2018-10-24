package com.leetcode.longestValidParentheses_32;

public class DynamicProgramming extends Solution {
    @Override
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            if (s.charAt(i - 1) == '(') {
                dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
            } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
