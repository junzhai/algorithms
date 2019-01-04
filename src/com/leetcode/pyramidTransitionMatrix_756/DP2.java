package com.leetcode.pyramidTransitionMatrix_756;

import java.util.List;

public class DP2 extends Solution {
    @Override
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int[][] mapping = new int[7][7];
        for (String a : allowed) {
            mapping[a.charAt(0) - 'A'][a.charAt(1) - 'A'] |= 1 << a.charAt(2) - 'A';
        }

        int len = bottom.length() - 1;
        int[][] dp = new int[len][len];
        for (int i = 1; i <= len; i++) {
            int col = i - 1, v = mapping[bottom.charAt(i - 1) - 'A'][bottom.charAt(i) - 'A'];
            while (col >= 0) {
                if (v == 0) {
                    return false;
                }
                int row = i - col - 1;
                dp[row][col] = v;
                if (col > 0) {
                    v = cal(mapping, dp[row][col - 1], v);
                }
                col -= 1;
            }
        }
        return true;
    }

    private int cal(int[][] mapping, int a, int b) {
        int ret = 0;
        for (int i = 0, ma = 1; i < 7; i++, ma <<= 1) {
            if ((a & ma) > 0) {
                for (int j = 0, mb = 1; j < 7; j++, mb <<= 1) {
                    if ((b & mb) > 0) {
                        ret |= mapping[i][j];
                    }
                }
            }
        }
        return ret;
    }
}
