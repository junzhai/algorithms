package com.leetcode.com.algorithms.burstBalloons_312;

public class LastBurstIterativeDP extends Solution {
    @Override
    public int maxCoins(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[][] dp = new int[len][len];
        for (int c = 0; c < len; c++) {
            for (int b = 0; b + c < len; b++) {
                int e = b + c, m = (b > 0 ? nums[b - 1] : 1) * (e < len - 1 ? nums[e + 1] : 1);
                if (b == e) {
                    dp[b][e] = nums[b] * m;
                    continue;
                }
                int max = nums[b] * m + dp[b + 1][e];
                for (int i = b + 1; i < e; i++) {
                    max = Math.max(max, nums[i] * m + dp[b][i - 1] + dp[i + 1][e]);
                }
                max = Math.max(max, nums[e] * m + dp[b][e - 1]);
                dp[b][e] = max;
            }
        }
        return dp[0][len - 1];
    }
}
