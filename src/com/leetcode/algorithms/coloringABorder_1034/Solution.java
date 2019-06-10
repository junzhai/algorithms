package com.leetcode.algorithms.coloringABorder_1034;

public class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        helper(grid, r0, c0);
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = grid[i][j] >= 2048 ? color : (grid[i][j] & 0x3ff);
            }
        }
        return grid;
    }

    private void helper(int[][] grid, int r, int c) {
        int row = grid.length, col = grid[0].length, cc = grid[r][c];
        grid[r][c] += 1024;
        if (r == 0 || r == row - 1 || c == 0 || c == col - 1
                || (grid[r - 1][c] & 0x3ff) != cc
                || (grid[r][c + 1] & 0x3ff) != cc
                || (grid[r + 1][c] & 0x3ff) != cc
                || (grid[r][c - 1] & 0x3ff) != cc) {
            grid[r][c] += 1024;
        }

        if (r > 0 && grid[r - 1][c] == cc) {
            helper(grid, r - 1, c);
        }
        if (c + 1 < col && grid[r][c + 1] == cc) {
            helper(grid, r, c + 1);
        }
        if (r + 1 < row && grid[r + 1][c] == cc) {
            helper(grid, r + 1, c);
        }
        if (c > 0 && grid[r][c - 1] == cc) {
            helper(grid, r, c - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.colorBorder(new int[][]{{1, 1}, {1, 2}}, 0, 0, 3);
    }

}
