package com.leetcode.algorithms.gridIllumination_1001;

import org.junit.Assert;

abstract public class Solution {
    abstract public int[] gridIllumination(int N, int[][] lamps, int[][] queries);

    public static void main(String[] args) {
        Solution s = new Index();
        int[] ret;

        ret = s.gridIllumination(5,
                new int[][]{{0, 0}, {0, 1}, {0, 4}},
                new int[][]{{0, 0}, {0, 1}, {0, 2}});
        Assert.assertArrayEquals(new int[]{1, 1, 1}, ret);

        ret = s.gridIllumination(5,
                new int[][]{{0, 1}, {1, 0}},
                new int[][]{{1, 1}, {1, 1}});
        Assert.assertArrayEquals(new int[]{1, 0}, ret);

        ret = s.gridIllumination(10,
                new int[][]{{3, 4}, {6, 6}, {1, 8}, {4, 5}, {8, 7}, {0, 6}, {5, 2}, {1, 9}},
                new int[][]{{7, 9}, {2, 8}, {8, 6}, {6, 8}, {2, 8}});
        Assert.assertArrayEquals(new int[]{1, 1, 1, 1, 1}, ret);
    }
}
