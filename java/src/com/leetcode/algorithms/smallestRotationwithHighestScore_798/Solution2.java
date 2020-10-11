package com.leetcode.algorithms.smallestRotationwithHighestScore_798;

/**
 * N * N
 */
public class Solution2 extends Solution {
    @Override
    public int bestRotation(int[] A) {
        int len = A.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i < A[i]) {
                for (int j = i + 1; j <= i - A[i] + len; j++) {
                    dp[j] += 1;
                }
            } else {
                for (int j = 0; j <= i - A[i]; j++) {
                    dp[j] += 1;
                }
                if (i < len - 1) {
                    for (int j = i + 1; j <= len - 1; j++) {
                        dp[j] += 1;
                    }
                }
            }
        }

        int max = 0, ret = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] > max) {
                max = dp[i];
                ret = i;
            }
        }
        return ret;
    }
}
