package com.leetcode.guessNumberHigherorLowerII_375;

import com.pattern.DP;

import static org.junit.Assert.assertEquals;

@DP
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int d = 1; d < n; d++) {
            for (int b = 1; b + d <= n; b++) {
                int e = b + d;
                dp[b][e] = Integer.MAX_VALUE;
                for (int i = b; i < e; i++) {
                    int cost = Math.max(len(dp, b, i - 1), len(dp, i + 1, e)) + i;
                    if (cost < dp[b][e]) {
                        dp[b][e] = cost;
                    }
                }
            }
        }
        return dp[1][n];
    }

    private int len(int[][] dp, int b, int e) {
        if (b >= e) {
            return 0;
        }
        return dp[b][e];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.getMoneyAmount(100);
        assertEquals(400, ret);

        ret = s.getMoneyAmount(20);
        assertEquals(49, ret);

        ret = s.getMoneyAmount(19);
        assertEquals(46, ret);
    }
}
