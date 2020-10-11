package com.leetcode.algorithms.coinChange_322;

public class DPTopDown extends Solution {
    @Override
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        return inner(coins, amount, new int[amount + 1]);
    }

    private int inner(int[] coins, int amount, int[] dp) {
        if (dp[amount] != 0) {
            return dp[amount];
        }

        int ret = Integer.MAX_VALUE;
        for (int coin : coins) {
            int delta = amount - coin;
            if (delta == 0) {
                ret = 1;
                break;
            }
            if (delta > 0) {
                int t = inner(coins, delta, dp);
                if (t > 0) {
                    ret = Math.min(ret, t + 1);
                }
            }
        }
        ret = ret == Integer.MAX_VALUE ? -1 : ret;
        dp[amount] = ret;
        return ret;
    }
}
