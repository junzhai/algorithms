package com.leetcode.algorithms.xxx_raceCar_818;

import com.leetcode.algorithms.pattern.DP;

import java.util.Arrays;

@DP
/**
 * 没有证明
 */
public class UseDP3 extends Solution {
    @Override
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= target; i++) {
            int op = 1, diff = 1;
            for (; i > diff; op++, diff <<= 1, diff++) {
                int j = i - diff;
                dp[i] = dp[j] + op + 2;
                for (int op1 = 1, diff1 = 1; j + diff1 < i; op1++, diff1 <<= 1, diff1++) {
                    int k = j + diff1;
                    dp[i] = Math.min(dp[i], dp[k] + 1 + op1 + 1 + op);
                }
            }
            if (i == diff) {
                dp[i] = Math.min(dp[i], op);
            } else {
                dp[i] = Math.min(dp[i], op + 1 + dp[diff - i]);
            }
        }
        return dp[target];
    }
}