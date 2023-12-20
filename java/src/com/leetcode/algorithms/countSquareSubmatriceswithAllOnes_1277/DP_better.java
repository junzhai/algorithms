package com.leetcode.algorithms.countSquareSubmatriceswithAllOnes_1277;

import com.pattern.algorithms.DP;

@DP
class DP_better extends Solution {

    @Override
    public int countSquares(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        int ret = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (r == 0 && c == 0) {
                    dp[r][c] = matrix[r][c];
                } else if (r == 0) {
                    dp[r][c] = matrix[r][c];
                } else if (c == 0) {
                    dp[r][c] = matrix[r][c];
                } else {
                    if (matrix[r][c] == 1) {
                        dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
                    }
                }
                ret += dp[r][c];
            }
        }

        return ret;
    }
}