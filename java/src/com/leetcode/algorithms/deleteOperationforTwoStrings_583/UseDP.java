package com.leetcode.algorithms.deleteOperationforTwoStrings_583;

import com.pattern.algorithms.DP;

import java.util.Arrays;

@DP
public class UseDP extends Solution {
    @Override
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int l1 = w1.length, l2 = w2.length;
        if (l1 == 0) {
            return l2;
        }

        if (l2 == 0) {
            return l1;
        }

        int[][] p2 = new int[26][0];
        for (int i = 0; i < l2; i++) {
            int index = w2[i] - 'a';
            int[] t = p2[index];
            t = Arrays.copyOf(t, t.length + 1);
            t[t.length - 1] = i;
            p2[index] = t;
        }

        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = i;
        }

        for (int r = 1; r <= l1; r++) {
            int[] p = p2[w1[r - 1] - 'a'];
            for (int c = 1; c <= l2; c++) {
                int v = dp[r - 1][c] + 1;
                for (int i : p) {
                    if (i >= c) {
                        break;
                    }
                    v = Math.min(v, dp[r - 1][i] + c - i - 1);
                }
                dp[r][c] = v;
            }
        }

        return dp[l1][l2];
    }
}
