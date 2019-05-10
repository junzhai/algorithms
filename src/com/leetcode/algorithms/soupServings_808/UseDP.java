package com.leetcode.algorithms.soupServings_808;

import com.leetcode.algorithms.pattern.DP;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@DP
public class UseDP extends Solution {
    @Override
    public double soupServings(int N) {
        if (N > 4800) {
            return 1;
        }

        if (N == 0) {
            return 0.5;
        }

        int len = (N + 24) / 25;
        double[][] dp = new double[len][len];
        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                double p = r < 4? 1 : dp[r - 4][c];
                if (r < 3 && c < 1) {
                    p += 0.5;
                } else if (r < 3) {
                    p += 1;
                } else if (c >= 1) {
                    p += dp[r - 3][c - 1];
                }
                if (r < 2 && c < 2) {
                    p += 0.5;
                } else if (r < 2) {
                    p += 1;
                } else if (c >= 2) {
                    p += dp[r - 2][c - 2];
                }
                if (r < 1 && c < 3) {
                    p += 0.5;
                } else if (r < 1) {
                    p += 1;
                } else if (c >= 3) {
                    p += dp[r - 1][c - 3];
                }
                dp[r][c] = p / 4;
            }
        }
        return len == 0 ? 0.5 : dp[len - 1][len - 1];
    }
}
