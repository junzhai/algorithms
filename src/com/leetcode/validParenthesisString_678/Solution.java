package com.leetcode.validParenthesisString_678;

public class Solution {
    public boolean checkValidString(String s) {
        int c = 0, star = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    c += 1;
                    break;
                case ')':
                    if (c == 0 && star < 1) {
                        return false;
                    }
                    star = c == 0 ? star - 1 : star;
                    c = c == 0 ? 0 : c - 1;
                    break;
                default:
                    star += 1;
            }
        }

        if (c == 0) {
            return true;
        }

        c = 0;
        star = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            switch (ch) {
                case ')':
                    c += 1;
                    break;
                case '(':
                    if (c == 0 && star < 1) {
                        return false;
                    }
                    star = c == 0 ? star - 1 : star;
                    c = c == 0 ? 0 : c - 1;
                    break;
                default:
                    star += 1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean ret;
        ret = solution.checkValidString("(*))");
        System.out.println("done --> true, " + ret);
    }
}