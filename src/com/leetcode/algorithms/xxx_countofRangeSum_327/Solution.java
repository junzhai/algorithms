package com.leetcode.algorithms.xxx_countofRangeSum_327;

import org.junit.Assert;

abstract public class Solution {
    abstract public int countRangeSum(int[] nums, int lower, int upper);

    public static void main(String[] args) {
//        Solution s = new UsingBST();
//        Solution s = new UsingBST2();
//        Solution s = new UsingBST3();
//        Solution s = new UsingArray();
//        Solution s = new BruteForce();
//        Solution s = new RollingSuminBIT();
        Solution s = new MergeSortRollingSum();
//        Solution s = new RollingSuminSegmentTree();

        int ret;

        ret = s.countRangeSum(new int[]{}, 0, 0);
        Assert.assertEquals(0, ret);

        ret = s.countRangeSum(new int[]{-2, 5, -1}, -2, 2);
        Assert.assertEquals(3, ret);

        ret = s.countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864);
        Assert.assertEquals(3, ret);

    }
}
