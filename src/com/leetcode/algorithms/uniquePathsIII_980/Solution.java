package com.leetcode.algorithms.uniquePathsIII_980;

import org.junit.Assert;

public class Solution {
    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, targetCount = 0, x = 0, y = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    targetCount += 1;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }

        int[] ret = new int[1];
        helper(grid, rows, cols, targetCount, x, y, 0, ret);
        return ret[0];
    }

    private void helper(int[][] grid, int rows, int cols, int targetCount, int r, int c, int count, int[] ret) {
        boolean blocked = true, end = false;
        if (c + 1 < cols) {
            end |= grid[r][c + 1] == 2;
            if (grid[r][c + 1] == 0) {
                blocked = false;
                grid[r][c + 1] = 1;
                helper(grid, rows, cols, targetCount, r, c + 1, count + 1, ret);
                grid[r][c + 1] = 0;
            }
        }

        if (r + 1 < rows) {
            end |= grid[r + 1][c] == 2;
            if (grid[r + 1][c] == 0) {
                blocked = false;
                grid[r + 1][c] = 1;
                helper(grid, rows, cols, targetCount, r + 1, c, count + 1, ret);
                grid[r + 1][c] = 0;
            }
        }

        if (c > 0) {
            end |= grid[r][c - 1] == 2;
            if (grid[r][c - 1] == 0) {
                blocked = false;
                grid[r][c - 1] = 1;
                helper(grid, rows, cols, targetCount, r, c - 1, count + 1, ret);
                grid[r][c - 1] = 0;
            }
        }

        if (r > 0) {
            end |= grid[r - 1][c] == 2;
            if (grid[r - 1][c] == 0) {
                blocked = false;
                grid[r - 1][c] = 1;
                helper(grid, rows, cols, targetCount, r - 1, c, count + 1, ret);
                grid[r - 1][c] = 0;
            }
        }

        if (blocked && end && count == targetCount) {
            ret[0] += 1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.uniquePathsIII(new int[][]{
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2}
        });
        Assert.assertEquals(20, ret);

        ret = s.uniquePathsIII(new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        });
        Assert.assertEquals(4, ret);

        ret = s.uniquePathsIII(new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        });
        Assert.assertEquals(2, ret);
    }
}
