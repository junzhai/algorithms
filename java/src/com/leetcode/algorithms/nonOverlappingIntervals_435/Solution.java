package com.leetcode.algorithms.nonOverlappingIntervals_435;

import org.junit.Assert;

abstract public class Solution {
    abstract public int eraseOverlapIntervals(int[][] intervals);

    public static void main(String[] args) {
//        Solution s = new DPWithBinarySearch();
        Solution s = new DPWithoutBinarySearch();
        int ret;
        ret = s.eraseOverlapIntervals(new int[][]{
                {1, 100}, {11, 22}, {1, 11}, {2, 12}
        });
        Assert.assertEquals(2, ret);
    }
}
