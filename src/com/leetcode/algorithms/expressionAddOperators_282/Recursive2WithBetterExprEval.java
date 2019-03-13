package com.leetcode.algorithms.expressionAddOperators_282;

import java.util.ArrayList;
import java.util.List;

public class Recursive2WithBetterExprEval extends Solution {
    @Override
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        if (num.length() == 0) {
            return ret;
        }
        split(ret, num, 0, new long[num.length()], 0, new long[num.length()], new char[num.length() - 1], target);
        return ret;
    }

    private void split(List<String> ret, String num, int s, long[] vals, int len, long[] opr, char[] op, int target) {
        if (s >= num.length()) {
            cal(ret, vals, len, 1, vals[0], vals[0], op, target);
            return;
        }

        if (num.charAt(s) == '0') {
            vals[len] = 0;
            split(ret, num, s + 1, vals, len + 1, opr, op, target);
            return;
        }

        for (int i = s; i < num.length(); i++) {
            long a = Long.parseLong(num.substring(s, i + 1));
            vals[len] = a;
            split(ret, num, i + 1, vals, len + 1, opr, op, target);
        }
    }

    private void cal(List<String> ret, long[] vals, int len, int p, long s, long d, char[] op, int target) {
        if (p >= len) {
            if (s == target) {
                ret.add(dist(vals, len, op));
            }
            return;
        }

        long v = vals[p];

        op[p - 1] = '+';
        cal(ret, vals, len, p + 1, s + v, v, op, target);

        op[p - 1] = '-';
        cal(ret, vals, len, p + 1, s - v, -v, op, target);

        op[p - 1] = '*';
        long k = d * v;
        cal(ret, vals, len, p + 1, s - d + k, k, op, target);
    }

    private String dist(long[] vals, int len, char[] op) {
        String ret = String.valueOf(vals[0]);
        for (int i = 1; i < len; i++) {
            ret += String.valueOf(op[i - 1]) + String.valueOf(vals[i]);
        }
        return ret;
    }
}
