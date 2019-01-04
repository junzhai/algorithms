package com.leetcode.pyramidTransitionMatrix_756;

import java.util.List;

public class BackTrackingUsingBit extends Solution {
    @Override
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int[][] triples = new int[7][7];
        for (String a : allowed) {
            int a0 = a.charAt(0) - 'A', a1 = a.charAt(1) - 'A', a2 = a.charAt(2) - 'A';
            triples[a0][a1] |= (1 << a2);
        }

        int[][] bt = new int[8][8];
        bt[0][0] = bottom.charAt(0) - 'A';
        int[] len = new int[8];
        len[0] = 1;
        return helper(bottom, triples, bt, len, 0, bottom.charAt(1) - 'A');
    }

    private boolean helper(String bottom, int[][] triples, int[][] bt, int[] len, int r, int ch) {
        bt[r][len[r]] = ch;
        len[r] += 1;

        boolean ret = false;
        if (len[r] == 1) {
            ret = len[0] == bottom.length() || helper(bottom, triples, bt, len, 0, bottom.charAt(len[0]) - 'A');
        } else {
            int t = triples[bt[r][len[r] - 2]][bt[r][len[r] - 1]];
            for (int i = 0, m = 1; i < 7; i++) {
                if ((t & m) > 0 && helper(bottom, triples, bt, len, r + 1, i)) {
                    ret = true;
                    break;
                }
                m <<= 1;
            }
        }

        len[r] -= 1;
        return ret;
    }
}
