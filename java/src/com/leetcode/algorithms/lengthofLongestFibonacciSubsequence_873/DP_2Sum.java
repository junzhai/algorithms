package com.leetcode.algorithms.lengthofLongestFibonacciSubsequence_873;

import java.util.HashMap;
import java.util.Map;

@com.leetcode.algorithms.pattern.DP
public class DP_2Sum extends Solution {
    @Override
    public int lenLongestFibSubseq(int[] A) {
        int len = A.length, ret = 0;
        int[][] dp = new int[len][len];
        for (int i = 2; i < len; i++) {
            int a = 0, b = i - 1;
            while (a < b) {
                int sum = A[a] + A[b];
                if (sum < A[i]) {
                    a += 1;
                } else if (sum > A[i]) {
                    b -= 1;
                } else {
                    int c = dp[a][b] == 0? 3 : dp[a][b] + 1;
                    ret = Math.max(ret, c);
                    dp[b][i] = c;
                    a += 1;
                    b -= 1;
                }
            }
        }

        return ret;
    }
}
