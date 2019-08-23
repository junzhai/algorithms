package com.leetcode.algorithms.largestSumofAverages_813;

import com.leetcode.algorithms.pattern.DP;

@DP
public class UseDP2 extends Solution {
    @Override
    public double largestSumOfAverages(int[] A, int K) {
        int len = A.length;
        int[] sum = new int[len];
        sum[0] = A[0];
        for (int i = 1; i < len; i++) {
            sum[i] = A[i] + sum[i - 1];
        }

        double[][] dp = new double[len][K];
        for (int i = 0; i < len; i++) {
            dp[i][0] = (double) sum[i] / (i + 1);
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                double v = (double) (sum[j] - sum[i]) / (j - i);
                for (int k = 0; k < K - 1; k++) {
                    if (dp[i][k] == 0) {
                        break;
                    }
                    dp[j][k + 1] = Math.max(dp[j][k + 1], dp[i][k] + v);
                }
            }
        }

        return dp[len - 1][K - 1];
    }
}
