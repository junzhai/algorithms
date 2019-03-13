package com.leetcode.algorithms.longestValidParentheses_32;

import java.util.Stack;

public class BruteForce extends Solution {
    @Override
    public int longestValidParentheses(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j += 2) {
                if (check(s, i, j)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public boolean check(String s, int b, int e) {
        Stack<Boolean> stack = new Stack<>();
        for (int i = b; i <= e; i++) {
            if (s.charAt(i) == '(') {
                stack.push(true);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
