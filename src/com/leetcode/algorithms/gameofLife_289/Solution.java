package com.leetcode.algorithms.gameofLife_289;

public class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int one = 0;
                if (board[r][c] > 0) {
                    one = board[r][c] - 1;
                    if (c + 1 < col) {
                        board[r][c + 1] += board[r][c + 1] > 0 ? 1 : -1;
                        one += board[r][c + 1] > 0 ? 1 : 0;
                    }
                    if (r + 1 < row && c > 0) {
                        board[r + 1][c - 1] += board[r + 1][c - 1] > 0 ? 1 : -1;
                        one += board[r + 1][c - 1] > 0 ? 1 : 0;
                    }
                    if (r + 1 < row) {
                        board[r + 1][c] += board[r + 1][c] > 0 ? 1 : -1;
                        one += board[r + 1][c] > 0 ? 1 : 0;
                    }
                    if (r + 1 < row && c + 1 < col) {
                        board[r + 1][c + 1] += board[r + 1][c + 1] > 0 ? 1 : -1;
                        one += board[r + 1][c + 1] > 0 ? 1 : 0;
                    }
                    board[r][c] = one < 2 ? 0 : (one > 3 ? 0 : 1);
                } else {
                    one = - board[r][c];
                    if (c + 1 < col) {
                        one += board[r][c + 1] > 0 ? 1 : 0;
                    }
                    if (r + 1 < row && c > 0) {
                        one += board[r + 1][c - 1] > 0 ? 1 : 0;
                    }
                    if (r + 1 < row) {
                        one += board[r + 1][c] > 0 ? 1 : 0;
                    }
                    if (r + 1 < row && c + 1 < col) {
                        one += board[r + 1][c + 1] > 0 ? 1 : 0;
                    }
                    board[r][c] = one == 3 ? 1 : 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        s.gameOfLife(input);
    }
}
