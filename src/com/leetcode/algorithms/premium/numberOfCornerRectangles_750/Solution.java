package com.leetcode.algorithms.premium.numberOfCornerRectangles_750;

import org.junit.Assert;

/**
 * Given a grid where each entry is only 0 or 1, find the number of corner rectangles.
 * <p>
 * A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners
 * need to have the value 1. Also, all four 1s used must be distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: grid =
 * [[1, 0, 0, 1, 0],
 * [0, 0, 1, 0, 1],
 * [0, 0, 0, 1, 0],
 * [1, 0, 1, 0, 1]]
 * Output: 1
 * Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
 * Example 2:
 * <p>
 * Input: grid =
 * [[1, 1, 1],
 * [1, 1, 1],
 * [1, 1, 1]]
 * Output: 9
 * Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
 * Example 3:
 * <p>
 * Input: grid =
 * [[1, 1, 1, 1]]
 * Output: 0
 * Explanation: Rectangles must have four distinct corners.
 * Note:
 * <p>
 * The number of rows and columns of grid will each be in the range [1, 200].
 * Each grid[i][j] will be either 0 or 1.
 * The number of 1s in the grid will be at most 6000.
 */
public class Solution {
    public int countCornerRectangles(int[][] grid) {
        int ret = 0;
        for (int r = 1; r < grid.length; r++) {
            int cc1 = 0, cc2 = 0;
            for (int c = 0; c < grid[r].length; c++) {
                cc1 += grid[r][c] * grid[0][c];
                if (r != grid.length - 1) {
                    cc2 += grid[r][c] * grid[grid.length - 1][c];
                }
            }
            ret += cc1 * (cc1 - 1) / 2;
            ret += cc2 * (cc2 - 1) / 2;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.countCornerRectangles(new int[][]{
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1}
        });
        Assert.assertEquals(1, ret);

        ret = s.countCornerRectangles(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });
        Assert.assertEquals(9, ret);

        ret = s.countCornerRectangles(new int[][]{
                {1, 1, 1, 1}
        });
        Assert.assertEquals(0, ret);
    }
}
