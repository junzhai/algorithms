package com.leetcode.algorithms.smallestIntegerDivisiblebyK_1015;

public class Mod extends Solution {
    @Override
    public int smallestRepunitDivByK(int K) {
        boolean[] dp = new boolean[K];
        int m = 1 % K, ret = 1;

        while (m != 0) {
            if (dp[m]) {
                return -1;
            }
            dp[m] = true;
            m = (10 * m + 1) % K;
            ret += 1;
        }

        return ret;
    }
}
