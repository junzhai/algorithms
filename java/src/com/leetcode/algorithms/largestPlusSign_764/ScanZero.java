package com.leetcode.algorithms.largestPlusSign_764;

public class ScanZero extends Solution {
    @Override
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            int min = Math.min(i + 1, N - i);
            for (int j = 0; j < N; j++) {
                dp[i][j] = Math.min(min, j + 1);
                dp[i][j] = Math.min(dp[i][j], N - j);
            }
        }

        for (int[] p : mines) {
            int r = p[0], c = p[1];
            dp[r][c] = 0;
            for (int i = c - 1, cc = 0; i >= 0; i--) {
                if (dp[r][i] == 0) {
                    break;
                }
                cc += 1;
                dp[r][i] = Math.min(dp[r][i], cc);
            }
            for (int i = c + 1, cc = 0; i < N; i++) {
                if (dp[r][i] == 0) {
                    break;
                }
                cc += 1;
                dp[r][i] = Math.min(dp[r][i], cc);
            }

            for (int i = r - 1, cc = 0; i >= 0; i--) {
                if (dp[i][c] == 0) {
                    break;
                }
                cc += 1;
                dp[i][c] = Math.min(dp[i][c], cc);
            }
            for (int i = r + 1, cc = 0; i < N; i++) {
                if (dp[i][c] == 0) {
                    break;
                }
                cc += 1;
                dp[i][c] = Math.min(dp[i][c], cc);
            }
        }

        int ret = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret;
    }
}
