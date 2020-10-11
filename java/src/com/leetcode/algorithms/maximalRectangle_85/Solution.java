package com.leetcode.algorithms.maximalRectangle_85;

import org.junit.Assert;

public abstract class Solution {
    public abstract int maximalRectangle(char[][] matrix);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new HistogramBinarySearch(),
                new Histogram()
        };

        for (Solution s : solutions) {
            int ret = s.maximalRectangle(new char[][]{
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'}
            });
            Assert.assertEquals(ret, 6);
        }
    }
}
