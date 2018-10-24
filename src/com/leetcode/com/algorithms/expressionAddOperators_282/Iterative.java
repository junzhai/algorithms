package com.leetcode.com.algorithms.expressionAddOperators_282;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Iterative extends Solution {
    @Override
    public List<String> addOperators(String num, int target) {
        if (num.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Long> nonZero = new HashMap<>(), zero = new HashMap<>();
        long c = num.charAt(0) - '0';
        if (c == 0) {
            zero.put(String.valueOf(c), c);
        } else {
            nonZero.put(String.valueOf(c), c);
        }

        for (int i = 1; i < num.length(); i++) {
            c = num.charAt(i) - '0';
            Map<String, Long> n0 = new HashMap<>(), n1 = new HashMap<>();

            if (c == 0) {
                for (String e : nonZero.keySet()) {
                    long v = nonZero.get(e);
                    n0.put(e + "+" + c, v);
                    n0.put(e + "-" + c, v);
                    String n = e + "*" + c;
                    n0.put(n, eval(n));
                    n = e + c;
                    n1.put(n, eval(n));
                }
                for (String e : zero.keySet()) {
                    long v = zero.get(e);
                    n0.put(e + "+" + c, v);
                    n0.put(e + "-" + c, v);
                    String n = e + "*" + c;
                    n0.put(n, eval(n));
                }
            } else {
                for (String e : nonZero.keySet()) {
                    long v = nonZero.get(e);
                    n1.put(e + "+" + c, v + c);
                    n1.put(e + "-" + c, v - c);
                    String n = e + "*" + c;
                    n1.put(n, eval(n));
                    n = e + c;
                    n1.put(n, eval(n));
                }
                for (String e : zero.keySet()) {
                    long v = zero.get(e);
                    n1.put(e + "+" + c, v + c);
                    n1.put(e + "-" + c, v - c);
                    String n = e + "*" + c;
                    n1.put(n, eval(n));
                }
            }
            nonZero = n1;
            zero = n0;
        }

        List<String> ret = new ArrayList<>();
        for (String e : nonZero.keySet()) {
            if (nonZero.get(e) == target) {
                ret.add(e);
            }
        }
        for (String e : zero.keySet()) {
            if (zero.get(e) == target) {
                ret.add(e);
            }
        }
        return ret;
    }

    private long eval(String e) {
        String[] s = e.split("\\+");
        long ret = 0;
        for (String p : s) {
            ret += evalMinus(p);
        }
        return ret;
    }

    private long evalMinus(String e) {
        String[] s = e.split("-");
        long ret = evalMul(s[0]);
        for (int i = 1; i < s.length; i++) {
            ret -= evalMul(s[i]);
        }
        return ret;
    }

    private long evalMul(String e) {
        String[] s = e.split("\\*");
        long ret = Long.parseLong(s[0]);
        for (int i = 1; i < s.length; i++) {
            ret *= Long.parseLong(s[i]);
        }
        return ret;
    }
}
