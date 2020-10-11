package com.leetcode.algorithms.KInversePairsArray_629;

import org.junit.Assert;

public class Solution {
    public int kInversePairs(int n, int k) {
        int m = (int) Math.pow(10, 9) + 7;
        int[][] dp = new int[n][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (j > i) {
                    if (dp[i][j] < dp[i - 1][j - i - 1]) {
                        dp[i][j] += m;
                    }
                    dp[i][j] -= dp[i - 1][j - i - 1];
                }
                dp[i][j] %= m;
            }
        }

        return dp[n - 1][k];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.kInversePairs(10, 1);
        Assert.assertEquals(9, ret);

        ret = s.kInversePairs(1000, 1000);
        Assert.assertEquals(663677020, ret);
    }
}
