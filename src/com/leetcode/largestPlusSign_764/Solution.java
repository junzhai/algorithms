package com.leetcode.largestPlusSign_764;

import org.junit.Assert;

abstract public class Solution {
    abstract public int orderOfLargestPlusSign(int N, int[][] mines);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new ScanZero(),
                new ScanMatrix()
        };

        int ret;

        for (Solution s : solutions) {
            ret = s.orderOfLargestPlusSign(5, new int[][]{{4, 2}});
            Assert.assertEquals(2, ret);

            ret = s.orderOfLargestPlusSign(1, new int[][]{{0, 0}});
            Assert.assertEquals(0, ret);

            ret = s.orderOfLargestPlusSign(2, new int[][]{});
            Assert.assertEquals(1, ret);
        }
    }
}
