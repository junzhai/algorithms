package com.leetcode.algorithms.deleteOperationforTwoStrings_583;

import com.leetcode.algorithms.pattern.DP;

import java.util.Arrays;

@DP
public class UnknownDPPath extends Solution {
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

        int[][] dp = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(dp, 0, 0, w1, w2, p2);
    }

    private int helper(int[][] dp, int r, int c, char[] w1, char[] w2, int[][] p2) {
        int l1 = w1.length, l2 = w2.length;
        if (r == l1) {
            return l2 - c;
        }

        if (c == l2) {
            return l1 - r;
        }

        if (dp[r][c] >= 0) {
            return dp[r][c];
        }


        for (int i = r; i < l1; i++) {
            int[] p = p2[w1[i] - 'a'];
            if (p.length > 0 && p[p.length - 1] >= c) {
                int v = helper(dp, i + 1, c, w1, w2, p2) + 1;
                for (int j = p.length - 1; j >= 0; j--) {
                    if (p[j] < c) {
                        break;
                    }
                    v = Math.min(v, helper(dp, i + 1, p[j] + 1, w1, w2, p2) + p[j] - c);
                }
                dp[r][c] = i - r + v;
                return dp[r][c];
            }
        }
        dp[r][c] = l1 - r + l2 - c;
        return dp[r][c];
    }
}
