package com.leetcode.com.algorithms.coinChange_322;

import java.util.Arrays;

public class DPBottomUp extends Solution {
    @Override
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int coin : coins) {
                if (coin > amount) {
                    continue;
                }
                if (i + coin <= amount) {
                    dp[i + coin] = Math.min(dp[i] + 1, dp[i + coin]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
