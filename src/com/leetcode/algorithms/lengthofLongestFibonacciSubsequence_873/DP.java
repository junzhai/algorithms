package com.leetcode.algorithms.lengthofLongestFibonacciSubsequence_873;

import java.util.HashMap;
import java.util.Map;

@com.leetcode.algorithms.pattern.DP
public class DP extends Solution {
    @Override
    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> s = new HashMap<>();
        int len = A.length, ret = 0;
        for (int i = 0; i < len; i++) {
            s.put(A[i], i);
        }
        int[][] dp = new int[len][len];
        for (int i = 1; i < len - 1; i++) {
            for (int j = 0; j < i; j++) {
                int sum = A[i] + A[j];
                if (s.containsKey(sum)) {
                    int c = dp[j][i] == 0 ? 3 : dp[j][i] + 1;
                    ret = Math.max(ret, c);
                    dp[i][s.get(sum)] = c;
                }
            }
        }

        return ret;
    }
}
