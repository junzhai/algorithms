package com.leetcode.com.algorithms.longestValidParentheses_32;

public class UsingStack extends Solution {
    @Override
    public int longestValidParentheses(String s) {
        int[] stack = new int[s.length() + 1];
        stack[0] = -1;
        int top = 1, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack[top++] = i;
                continue;
            }
            if (top == 1) {
                stack[0] = i;
                continue;
            }

            max = Math.max(max, i - stack[top - 2]);
            top -= 1;
        }
        return max;
    }
}
