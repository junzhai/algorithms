package com.leetcode.expressionAddOperators_282;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Recursive extends Solution {
    @Override
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        if (num.isEmpty()) {
            return ret;
        }
        long[] oprands = new long[num.length()];
        char[] ops = new char[num.length() - 1];
        inner(ret, new StringBuilder(), num, 0, target, 0L, oprands, ops, 0);
        return ret;
    }

    private void inner(List<String> ret, StringBuilder sb,
                       String num, int index, int target,
                       long numCtx,
                       long[] oprands, char[] ops, int opLen) {
        if (index >= num.length()) {
            if (cal(oprands, ops, opLen) == target) {
                ret.add(display(sb, oprands, ops, opLen));
            }
            return;
        }

        long c = numCtx + (num.charAt(index) - '0');

        oprands[opLen] = c;
        if (index == num.length() - 1) {
            inner(ret, sb, num, index + 1, target, 0, oprands, ops, opLen);
            return;
        }

        ops[opLen] = '+';
        inner(ret, sb, num, index + 1, target, 0, oprands, ops, opLen + 1);

        ops[opLen] = '-';
        inner(ret, sb, num, index + 1, target, 0, oprands, ops, opLen + 1);

        ops[opLen] = '*';
        inner(ret, sb, num, index + 1, target, 0, oprands, ops, opLen + 1);

        if (c != 0) {
            inner(ret, sb, num, index + 1, target, c * 10, oprands, ops, opLen);
        }
    }

    private long cal(long[] oprands, char[] ops, int opLen) {
        Stack<Long> s = new Stack<>();
        s.push(oprands[0]);
        for (int i = 1; i <= opLen; i++) {
            long o = oprands[i];
            switch (ops[i - 1]) {
                case '+':
                    s.push(o);
                    break;
                case '-':
                    s.push(-o);
                    break;
                default:
                    s.push(s.pop() * o);
                    break;
            }
        }
        long ret = 0;
        while (!s.isEmpty()) {
            ret += s.pop();
        }
        return ret;
    }

    private String display(StringBuilder sb, long[] oprands, char[] ops, int opLen) {
        sb.setLength(0);
        sb.append(oprands[0]);
        for (int i = 1; i <= opLen; i++) {
            sb.append(ops[i - 1]).append(oprands[i]);
        }
        return sb.toString();
    }
}
