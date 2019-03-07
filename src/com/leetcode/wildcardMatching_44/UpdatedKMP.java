package com.leetcode.wildcardMatching_44;

import com.pattern.KMP;

@KMP
public class UpdatedKMP extends Solution {
    public boolean isMatch(String s, String p) {
        int b = p.indexOf('*');
        if (b == -1) {
            return simpleMatch(s, p);
        }

        if (b > 0) {
            if (!simpleMatch(s.substring(0, Math.min(s.length(), b)), p.substring(0, b))) {
                return false;
            }
            s = s.substring(b);
        }

        int pl = p.length();
        int e = p.lastIndexOf('*');
        if (e < pl - 1) {
            if (!simpleMatch(s.substring(Math.max(0, s.length() - pl + 1 + e)), p.substring(e + 1))) {
                return false;
            }
            s = s.substring(0, s.length() - pl + 1 + e);
        }

        p = p.substring(b, e + 1);
        String[] ps = p.split("\\*");

        int[] pos = new int[1];
        for (String pp : ps) {
            if (pos[0] >= s.length()) {
                return false;
            }
            if (pp.isEmpty()) {
                continue;
            }
            int[] v = buildVector(pp);
            if (!kmpMatch(s, pos, pp, v)) {
                return false;
            }
        }

        return true;
    }

    private boolean simpleMatch(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }

        for (int i = 0; i < p.length(); i++) {
            char cs = s.charAt(i), cp = p.charAt(i);
            if (cs != cp && cp != '?') {
                return false;
            }
        }
        return true;
    }

    private int[] buildVector(String p) {
        int len = p.length();
        int[] ret = new int[len];
        for (int i = 2; i < len; i++) {
            int pos = i - 1;
            char ch = p.charAt(i - 1), c = p.charAt(ret[pos]);
            while (pos > 0 && ch != c && c != '?') {
                pos = ret[pos];
                c = p.charAt(ret[pos]);
            }
            ret[i] = pos > 0 ? ret[pos] + 1 : 0;
        }
        return ret;
    }

    private boolean kmpMatch(String s, int[] index, String p, int[] v) {
        int pos = 0, sl = s.length(), pl = p.length();
        while (index[0] < sl && pos < pl) {
            char sc = s.charAt(index[0]), pc = p.charAt(pos);
            if (sc == pc || pc == '?') {
                index[0] += 1;
                pos += 1;
                continue;
            }

            if (pos == 0) {
                index[0] += 1;
            } else {
                pos = v[pos];
            }
        }
        return pos >= pl;
    }
}
