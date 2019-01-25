package com.leetcode.removeInvalidParentheses_301;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        char[] ss = s.toCharArray();
        int r = 0, l = 0, sep = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (ss[i] == ')') {
                r += 1;
            } else if (ss[i] == '(') {
                if (r == 0) {
                    l += 1;
                    sep = i;
                } else {
                    r -= 1;
                }
            }
        }

        List<String> ls = new ArrayList<>(), rs = new ArrayList<>(), ret = new ArrayList<>();
        char[] buf = new char[s.length()];
        removeRight(ls, s.toCharArray(), 0, sep, buf, 0, 0, r);
        removeLeft(rs, s.toCharArray(), sep, s.length() - 1, buf, s.length() - 1, 0, l);

        if (ls.isEmpty() && rs.isEmpty()) {
            ret.add("");
            return ret;
        }

        if (ls.isEmpty()) {
            return rs;
        }

        if (rs.isEmpty()) {
            return ls;
        }

        for (String a : ls) {
            for (String b : rs) {
                ret.add(a + b);
            }
        }
        return ret;
    }

    private void removeRight(List<String> ret, char[] s, int b, int e, char[] buf, int len, int sum, int count) {
        if (count == 0) {
            String v = new String(buf, 0, len) + new String(s, b, e - b);
            if (!v.isEmpty()) {
                ret.add(v);
            }
            return;
        }

        boolean pre = false;
        for (int i = b; i < e && sum >= 0; i++) {
            if (s[i] == ')' && !pre) {
                removeRight(ret, s, i + 1, e, buf, len, sum, count - 1);
            }

            if (s[i] == ')') {
                sum -= 1;
            }

            if (s[i] == '(') {
                sum += 1;
            }

            pre = s[i] == ')';
            buf[len++] = s[i];
        }
    }

    private void removeLeft(List<String> ret, char[] s, int b, int e, char[] buf, int pos, int sum, int count) {
        if (count == 0) {
            String v = new String(s, b, e - b + 1) + new String(buf, pos + 1, s.length - pos - 1);
            if (!v.isEmpty()) {
                ret.add(v);
            }

            return;
        }

        boolean pre = false;
        for (int i = e; i >= b && sum >= 0; i--) {
            if (s[i] == '(' && !pre) {
                removeLeft(ret, s, b, i - 1, buf, pos, sum, count - 1);
            }

            if (s[i] == ')') {
                sum += 1;
            }

            if (s[i] == '(') {
                sum -= 1;
            }

            pre = s[i] == '(';
            buf[pos--] = s[i];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ret;

        ret = s.removeInvalidParentheses("())(()(()");
        assertEquals(2, ret.size());

        ret = s.removeInvalidParentheses("(())()a)()");
        assertEquals(3, ret.size());

        ret = s.removeInvalidParentheses("())((()");
        assertEquals(1, ret.size());

        ret = s.removeInvalidParentheses("()))(()");
        assertEquals(1, ret.size());

        ret = s.removeInvalidParentheses(")(");
        assertEquals(1, ret.size());

        ret = s.removeInvalidParentheses("(a)())()");
        assertEquals(2, ret.size());

        ret = s.removeInvalidParentheses("()())()");
        assertEquals(2, ret.size());

        ret = s.removeInvalidParentheses("())())(()");
        assertEquals(2, ret.size());

        ret = s.removeInvalidParentheses("())())(a)b)");
        assertEquals(6, ret.size());
    }
}
