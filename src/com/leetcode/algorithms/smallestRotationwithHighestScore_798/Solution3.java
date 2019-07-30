package com.leetcode.algorithms.smallestRotationwithHighestScore_798;

/**
 * N
 */
public class Solution3 extends Solution {
    @Override
    public int bestRotation(int[] A) {
        int len = A.length, max = 0, ret = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (A[i] <= i) {
                int step = i - A[i] + 1;
                if (step < len) {
                    dp[step] += 1;
                }
                max += 1;
            }
        }

        for (int i = 0, step = 1, score = max; i < len - 1; i++, step++) {
            score -= dp[step];
            if (A[i] < len) {
                score += 1;
                int nstep = len - A[i] + step;
                if (nstep < len) {
                    dp[nstep] += 1;
                }
            }
            if (score > max) {
                max = score;
                ret = step;
            }
        }
        return ret;
    }
}
