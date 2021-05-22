package com.leetcode.algorithms.largestSumofAverages_813;

import com.pattern.algorithms.DP;

@DP
public class UseDP1 extends Solution {
    @Override
    public double largestSumOfAverages(int[] A, int K) {
        int len = A.length;
        int[] sum = new int[len];
        sum[0] = A[0];
        for (int i = 1; i < len; i++) {
            sum[i] = A[i] + sum[i - 1];
        }

        double[][] dp = new double[len][K];
        return helper(dp, sum, -1, K);
    }

    private double helper(double[][] dp, int[] sum, int b, int k) {
        if (dp[b + 1][k - 1] > 0.0) {
            return dp[b + 1][k - 1];
        }

        int len = sum.length, m = b < 0 ? 0 : sum[b];
        if (k == 1) {
            double ret = (double) (sum[len - 1] - m) / (len - 1 - b);
            dp[b + 1][k - 1] = ret;
            return ret;
        }

        double ret = 0.0;
        for (int i = b + 1; i < len - k + 1; i++) {
            ret = Math.max(ret, (double) (sum[i] - m) / (i - b) + helper(dp, sum, i, k - 1));
        }
        dp[b + 1][k - 1] = ret;
        return ret;
    }
}
