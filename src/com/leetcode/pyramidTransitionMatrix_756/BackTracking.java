package com.leetcode.pyramidTransitionMatrix_756;

import java.util.List;

public class BackTracking extends Solution {
    @Override
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        String[][] triples = new String[7][7];
        for (String a : allowed) {
            String t = triples[a.charAt(0) - 'A'][a.charAt(1) - 'A'];
            triples[a.charAt(0) - 'A'][a.charAt(1) - 'A'] = (t == null ? "" : t) + String.valueOf(a.charAt(2));
        }

        int[][] bt = new int[8][8];
        bt[0][0] = bottom.charAt(0) - 'A';
        int[] len = new int[8];
        len[0] = 1;
        return helper(bottom, triples, bt, len, 0, bottom.charAt(1) - 'A');
    }

    private boolean helper(String bottom, String[][] triples, int[][] bt, int[] len, int r, int ch) {
        bt[r][len[r]] = ch;
        len[r] += 1;

        boolean ret = false;
        if (len[r] == 1) {
            ret = len[0] == bottom.length() || helper(bottom, triples, bt, len, 0, bottom.charAt(len[0]) - 'A');
        } else {
            String t = triples[bt[r][len[r] - 2]][bt[r][len[r] - 1]];
            if (t != null) {
                for (int i = 0; i < t.length(); i++) {
                    if (helper(bottom, triples, bt, len, r + 1, t.charAt(i) - 'A')) {
                        ret = true;
                        break;
                    }
                }
            }
        }

        len[r] -= 1;
        return ret;
    }
}
