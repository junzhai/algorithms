package com.leetcode.algorithms.miniParser_385;

import com.leetcode.algorithms.common.NestedInteger;

public class Recursive extends Solution {
    @Override
    public NestedInteger deserialize(String s) {
        return helper(s, new int[1]);
    }

    private NestedInteger helper(String s, int[] p) {
        NestedInteger ret;
        char ch = s.charAt(p[0]);
        if (ch == '-' || Character.isDigit(ch)) {
            boolean neg = ch == '-';
            if (neg) {
                p[0] += 1;
            }
            int end = p[0];
            while (end < s.length() && Character.isDigit(s.charAt(end))) {
                end += 1;
            }
            int v = Integer.parseInt(s.substring(p[0], end));
            if (neg) {
                v = -v;
            }
            ret = new NestedInteger(v);
            p[0] = end;
            return ret;
        }

        ret = new NestedInteger();
        p[0] += 1;
        ch = s.charAt(p[0]);
        while (ch != ']') {
            if (ch == '-' || Character.isDigit(ch)) {
                ret.add(helper(s, p));
            } else if (ch == ',') {
                p[0] += 1;
            } else {
                ret.add(helper(s, p));
            }
            ch = s.charAt(p[0]);
        }

        p[0] += 1;
        return ret;
    }
}