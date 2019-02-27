package com.leetcode.largestPlusSign_764;

public class ScanMatrix extends Solution {
    @Override
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] matrix = new int[N][N], dp = new int[N][N];
        for (int[] p : mines) {
            int r = p[0], c = p[1];
            matrix[r][c] = 1;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0, s = 0; c < N; c++) {
                s = matrix[r][c] == 1 ? 0 : s + 1;
                dp[r][c] = s;
            }
            for (int c = N - 1, s = 0; c >= 0; c--) {
                s = matrix[r][c] == 1 ? 0 : s + 1;
                dp[r][c] = Math.min(dp[r][c], s);
            }
        }

        int ret = 0;
        for (int c = 0; c < N; c++) {
            for (int r = 0, s = 0; r < N; r++) {
                s = matrix[r][c] == 1 ? 0 : s + 1;
                dp[r][c] = Math.min(dp[r][c], s);
            }
            for (int r = N - 1, s = 0; r >= 0; r--) {
                s = matrix[r][c] == 1 ? 0 : s + 1;
                dp[r][c] = Math.min(dp[r][c], s);
                ret = Math.max(ret, dp[r][c]);
            }
        }

        return ret;
    }
}
