package com.leetcode.longestValidParentheses_32;

public class WithoutExtraSpace extends Solution {
    @Override
    public int longestValidParentheses(String s) {
        int max = 0, b = 0, diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                diff += 1;
            } else {
                diff -= 1;
            }

            if (diff < 0) {
                b = i + 1;
                diff = 0;
            } else if (diff == 0) {
                max = Math.max(max, i - b + 1);
            }
        }

        b = s.length() - 1;
        diff = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                diff += 1;
            } else {
                diff -= 1;
            }

            if (diff < 0) {
                b = i - 1;
                diff = 0;
            } else if (diff == 0) {
                max = Math.max(max, b - i + 1);
            }
        }
        return max;
    }
}
