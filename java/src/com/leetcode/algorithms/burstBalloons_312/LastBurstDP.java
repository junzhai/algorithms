package com.leetcode.algorithms.burstBalloons_312;


public class LastBurstDP extends Solution {
    @Override
    public int maxCoins(int[] nums) {
        int l = nums.length;
        int[][] dp = new int[l][l];
        return max(nums, 0, nums.length - 1, 1, 1, dp);
    }

    private int max(int[] nums, int b, int e, int left, int right, int[][] dp) {
        if (b > e) {
            return 0;
        }

        int lr = left * right;
        if (e == b) {
            return nums[b] * lr;
        }

        if (dp[b][e] > 0) {
            return dp[b][e];
        }

        int ret = 0;
        for (int i = b; i <= e; i++) {
            int v = nums[i];
            ret = Math.max(ret, v * lr + max(nums, b, i - 1, left, v, dp) + max(nums, i + 1, e, v, right, dp));
        }
        dp[b][e] = ret;
        return ret;
    }
}
