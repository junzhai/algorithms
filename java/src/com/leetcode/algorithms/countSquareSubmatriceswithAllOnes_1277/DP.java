package com.leetcode.algorithms.countSquareSubmatriceswithAllOnes_1277;

@com.pattern.algorithms.DP
class DP extends Solution {

    @Override
    public int countSquares(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col], dp1 = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (r == 0 && c == 0) {
                    dp[r][c] = matrix[r][c];
                    dp1[r][c] = matrix[r][c];
                } else if (r == 0) {
                    dp1[r][c] = matrix[r][c];
                    dp[r][c] = dp[r][c - 1] + dp1[r][c];
                } else if (c == 0) {
                    dp1[r][c] = matrix[r][c];
                    dp[r][c] = dp[r - 1][c] + dp1[r][c];
                } else {
                    dp1[r][c] = matrix[r][c];
                    if (matrix[r][c] == 1) {
                        for (int i = 1; i <= dp1[r - 1][c - 1]; i++) {
                            if (matrix[r - i][c] == 1 && matrix[r][c - i] == 1) {
                                dp1[r][c] += 1;
                            } else {
                                break;
                            }
                        }
                    }
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1] - dp[r - 1][c - 1] + dp1[r][c];
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}